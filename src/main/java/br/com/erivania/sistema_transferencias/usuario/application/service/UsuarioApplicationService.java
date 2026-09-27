package br.com.erivania.sistema_transferencias.usuario.application.service;

import br.com.erivania.sistema_transferencias.usuario.application.api.UsuarioResponse;
import br.com.erivania.sistema_transferencias.usuario.application.api.UsuarioResquest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class UsuarioApplicationService implements UsuarioService {
    @Override
    public UsuarioResponse criarUsuario(UsuarioResquest usuarioResquest) {
        return null;
    }
}
