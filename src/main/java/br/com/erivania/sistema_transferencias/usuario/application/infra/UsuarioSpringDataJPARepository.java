package br.com.erivania.sistema_transferencias.usuario.application.infra;

import br.com.erivania.sistema_transferencias.usuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioSpringDataJPARepository extends JpaRepository<Usuario, UUID> {
}
