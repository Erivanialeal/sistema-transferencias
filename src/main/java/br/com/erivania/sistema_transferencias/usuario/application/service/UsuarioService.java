package br.com.erivania.sistema_transferencias.usuario.application.service;

import br.com.erivania.sistema_transferencias.usuario.application.api.UsuarioResponse;
import br.com.erivania.sistema_transferencias.usuario.application.api.UsuarioResquest;
import jakarta.validation.Valid;

public interface UsuarioService {
    UsuarioResponse criarUsuario(UsuarioResquest usuarioResquest);


}
