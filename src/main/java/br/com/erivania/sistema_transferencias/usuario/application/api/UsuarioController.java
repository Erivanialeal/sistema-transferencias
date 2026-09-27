package br.com.erivania.sistema_transferencias.usuario.application.api;

import br.com.erivania.sistema_transferencias.usuario.application.service.UsuarioService;
import br.com.erivania.sistema_transferencias.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class UsuarioController implements UsuarioAPI {
    private final UsuarioService usuarioService;
    @Override
    public UsuarioResponse postUsuario(UsuarioResquest usuarioResquest) {
        log.info("[Inicia]UsuarioController - postUsuario");
        UsuarioResponse usuarioResponse = usuarioService.criarUsuario(usuarioResquest);
        log.info("[Finaliza]UsuarioController - postUsuario");
        return usuarioResponse;
    }
}
