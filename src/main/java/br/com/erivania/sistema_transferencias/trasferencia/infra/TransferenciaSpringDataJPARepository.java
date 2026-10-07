package br.com.erivania.sistema_transferencias.trasferencia.infra;

import br.com.erivania.sistema_transferencias.usuario.domain.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransferenciaSpringDataJPARepository extends JpaRepository<Transferencia, UUID> {
}
