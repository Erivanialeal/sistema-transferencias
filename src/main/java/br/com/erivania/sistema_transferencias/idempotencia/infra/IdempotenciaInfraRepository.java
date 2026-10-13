package br.com.erivania.sistema_transferencias.idempotencia.infra;

import br.com.erivania.sistema_transferencias.idempotencia.application.repository.IdempotenciaRepository;
import br.com.erivania.sistema_transferencias.idempotencia.domain.Idempotencia;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class IdempotenciaInfraRepository implements IdempotenciaRepository {
    private   final IdempotenciaSpringDataJPARepository idempotenciaSpringDataJPARepository;
    @Override
    public Optional<Idempotencia> buscarPorChave(String chave) {
        log.info("[Inicia]IdempotenciaInfraRepository -  buscarPorChave");
        Optional<Idempotencia> idempotencia = idempotenciaSpringDataJPARepository.findByChave(chave);
        log.info("[Finaliza]IdempotenciaInfraRepository -  buscarPorChave");
        return idempotencia;
    }

    @Override
    public Idempotencia salvar(Idempotencia idempotencia) {
        log.info("[Inicia]IdempotenciaInfraRepository - salvar");
        Idempotencia idempotencia1 = idempotenciaSpringDataJPARepository.save(idempotencia);
        log.info("[Finalizar]IdempotenciaInfraRepository - salvar");
        return idempotencia1;
    }
}
