package br.com.erivania.sistema_transferencias.trasferencia.application.service;

import br.com.erivania.sistema_transferencias.autorizador.AutorizadorExterno;
import br.com.erivania.sistema_transferencias.handler.APIException;
import br.com.erivania.sistema_transferencias.idempotencia.domain.Idempotencia;
import br.com.erivania.sistema_transferencias.idempotencia.domain.StatusIdepotencia;
import br.com.erivania.sistema_transferencias.idempotencia.infra.IdempotenciaInfraRepository;
import br.com.erivania.sistema_transferencias.trasferencia.application.api.TransferenciaRequest;
import br.com.erivania.sistema_transferencias.trasferencia.application.api.TransferenciaResponse;
import br.com.erivania.sistema_transferencias.trasferencia.application.repository.TransferenciaRepository;
import br.com.erivania.sistema_transferencias.usuario.application.repository.UsuarioRepository;
import br.com.erivania.sistema_transferencias.usuario.domain.TipoUsuario;
import br.com.erivania.sistema_transferencias.trasferencia.domain.Transferencia;
import br.com.erivania.sistema_transferencias.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class TransferenciaApplicationService implements TransferenciaService {
    private final UsuarioRepository usuarioRepository;
    private final TransferenciaRepository transferenciaRepository;
    private  final AutorizadorExterno autorizadorExterno;
    private  final IdempotenciaInfraRepository idempotenciaInfraRepository;


    @Override
    public TransferenciaResponse fazerTrasferencia(String idempoteceKey,TransferenciaRequest transferenciaRequest) {
        log.info("[Finaliza]TransferenciaApplicationService - fazerTrasferencia");

        Optional<Idempotencia> idempotenciaExistente = idempotenciaInfraRepository.buscarPorChave(idempoteceKey);
        if(idempotenciaExistente.isPresent()){
            Idempotencia idempotencia =idempotenciaExistente.get();
            if(idempotencia.getStatus() == StatusIdepotencia.CONCLUIDA){
                return TransferenciaResponse.builder()
                        .idTrasferencia(idempotencia.getTransferencia().getIdTransferencia()).build();
            }
            throw APIException.build(HttpStatus.CONFLICT,"Já existe uma operação em processamento com essa chave.");
        }

        if(transferenciaRequest.getValor().compareTo(BigDecimal.ZERO) <= 0){
            throw APIException.build(HttpStatus.BAD_REQUEST, "O valor da transferencia deve ser maior que zero!");
        }
        Usuario pagador = usuarioRepository.buscarUsuario(transferenciaRequest.getPagador());
        Usuario recebedor = usuarioRepository.buscarUsuario((transferenciaRequest.getRecebedor()));

        if(pagador.getSaldo().compareTo(transferenciaRequest.getValor()) < 0){
            throw APIException.build(HttpStatus.BAD_REQUEST, "Saldo insuficiente para realizar a transferência!");
        }
        if(pagador.getTipo() == TipoUsuario.LOJISTA){
            throw APIException.build(HttpStatus.FORBIDDEN, "Você não tem permição para fazer esse tipo de operação!");
        }
        if(transferenciaRequest.getValor().compareTo(BigDecimal.ZERO) <= 0){
            throw APIException.build(HttpStatus.BAD_REQUEST, "O valor da transferencia deve ser maior que zero!");
        }
        boolean autorizado = autorizadorExterno.autorizar();
        if(!autorizado){
            throw APIException.build(HttpStatus.FORBIDDEN, "Transferência não autorizada pelo serviço externo");
        }
        Transferencia transferencia = new Transferencia();
        transferencia.setValor(transferenciaRequest.getValor());
        transferencia.setPagador(pagador);
        transferencia.setRecebedor(recebedor);
        Transferencia transferenciaSalva = transferenciaRepository.salvar(transferencia);

        pagador.setSaldo(pagador.getSaldo().subtract(transferenciaRequest.getValor()));
        recebedor.setSaldo(recebedor.getSaldo().add(transferenciaRequest.getValor()));

        usuarioRepository.salvar(pagador);
        usuarioRepository.salvar(recebedor);

        Idempotencia idempotencia = new Idempotencia();
        idempotencia.setChave(idempoteceKey);
        idempotencia.setStatus(StatusIdepotencia.CONCLUIDA);
        idempotencia.setTransferencia(transferenciaSalva);

        idempotenciaInfraRepository.salvar(idempotencia);

        log.info("[Finaliza]TransferenciaApplicationService - fazerTrasferencia");
        return TransferenciaResponse.builder()
                .idTrasferencia(transferenciaSalva.getIdTransferencia())
                .build();
    }
}
