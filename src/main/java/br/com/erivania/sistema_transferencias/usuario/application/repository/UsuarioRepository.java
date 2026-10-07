package br.com.erivania.sistema_transferencias.usuario.application.repository;

import br.com.erivania.sistema_transferencias.usuario.application.api.UsuarioResponse;
import br.com.erivania.sistema_transferencias.usuario.domain.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UsuarioRepository {
    Usuario salvar(Usuario usuario);
    Usuario buscarUsuario(UUID idUsuario);
    List<Usuario> buscarTodos();
}
