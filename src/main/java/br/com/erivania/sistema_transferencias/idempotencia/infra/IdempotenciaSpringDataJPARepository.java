package br.com.erivania.sistema_transferencias.idempotencia.infra;

import br.com.erivania.sistema_transferencias.idempotencia.domain.Idempotencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IdempotenciaSpringDataJPARepository extends JpaRepository<Idempotencia, UUID> {
    Optional<Idempotencia> findByChave(String chave);
}
