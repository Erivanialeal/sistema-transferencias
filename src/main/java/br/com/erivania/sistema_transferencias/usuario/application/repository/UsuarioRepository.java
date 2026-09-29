package br.com.erivania.sistema_transferencias.usuario.application.repository;

import br.com.erivania.sistema_transferencias.usuario.domain.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository {
    Usuario salvar(Usuario usuario);
}
