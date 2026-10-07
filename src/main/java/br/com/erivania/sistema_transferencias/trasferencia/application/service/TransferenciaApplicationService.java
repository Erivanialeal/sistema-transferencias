package br.com.erivania.sistema_transferencias.trasferencia.application.service;

import br.com.erivania.sistema_transferencias.handler.APIException;
import br.com.erivania.sistema_transferencias.trasferencia.application.api.TransferenciaRequest;
import br.com.erivania.sistema_transferencias.trasferencia.application.api.TransferenciaResponse;
import br.com.erivania.sistema_transferencias.trasferencia.application.repository.TransferenciaRepository;
import br.com.erivania.sistema_transferencias.usuario.application.repository.UsuarioRepository;
import br.com.erivania.sistema_transferencias.usuario.domain.TipoUsuario;
import br.com.erivania.sistema_transferencias.usuario.domain.Transferencia;
import br.com.erivania.sistema_transferencias.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Log4j2
@RequiredArgsConstructor
public class TransferenciaApplicationService implements TransferenciaService {
    private final UsuarioRepository usuarioRepository;
    private final TransferenciaRepository transferenciaRepository;


    @Override
    public TransferenciaResponse fazerTrasferencia(TransferenciaRequest transferenciaRequest) {
        log.info("[Finaliza]TransferenciaApplicationService - fazerTrasferencia");
        if(transferenciaRequest.getValor().compareTo(BigDecimal.ZERO) <= 0){
            throw APIException.build(
                    HttpStatus.BAD_REQUEST,
                    "O valor da transferencia deve ser maior que zero!"
            );
        }
        Usuario pagador = usuarioRepository.buscarUsuario(transferenciaRequest.getPagador());
        Usuario recebedor = usuarioRepository.buscarUsuario((transferenciaRequest.getRecebedor()));

        if(pagador.getSaldo().compareTo(transferenciaRequest.getValor()) < 0){
            throw APIException.build(
                    HttpStatus.BAD_REQUEST,
                    "Saldo insuficiente para realizar a transferência!"
            );
        }
        if(pagador.getTipo() == TipoUsuario.LOJISTA){
            throw APIException.build(
                    HttpStatus.FORBIDDEN,
                    "Você não tem permição para fazer esse tipo de operação!"
            );
        }
        if(transferenciaRequest.getValor().compareTo(BigDecimal.ZERO) <= 0){
            throw APIException.build(
                    HttpStatus.BAD_REQUEST,
                    "O valor da transferencia deve ser maior que zero!"
            );
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

        log.info("[Finaliza]TransferenciaApplicationService - fazerTrasferencia");
        return TransferenciaResponse.builder()
                .idTrasferencia(transferenciaSalva.getIdTransferencia())
                .build();
    }
}
