package br.com.erivania.sistema_transferencias.usuario.application.service;

import br.com.erivania.sistema_transferencias.usuario.application.api.UsuarioListResponse;
import br.com.erivania.sistema_transferencias.usuario.application.api.UsuarioResponse;
import br.com.erivania.sistema_transferencias.usuario.application.api.UsuarioResquest;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface UsuarioService {
    UsuarioResponse criarUsuario(UsuarioResquest usuarioResquest);
    UsuarioResponse buscarUsuario(UUID idUsuario);
    List<UsuarioListResponse> buscarTodos();
}
