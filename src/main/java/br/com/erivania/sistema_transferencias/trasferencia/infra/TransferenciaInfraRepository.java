package br.com.erivania.sistema_transferencias.trasferencia.infra;

import br.com.erivania.sistema_transferencias.trasferencia.application.repository.TransferenciaRepository;
import br.com.erivania.sistema_transferencias.usuario.domain.Transferencia;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class TransferenciaInfraRepository implements TransferenciaRepository {
    private final TransferenciaSpringDataJPARepository transferenciaSpringDataJPARepository;
    @Override
    public Transferencia salvar(Transferencia transferencia) {
        log.info("[inicia]TransferenciaInfraRepository - salvar");
        return transferenciaSpringDataJPARepository.save(transferencia);
    }
}
