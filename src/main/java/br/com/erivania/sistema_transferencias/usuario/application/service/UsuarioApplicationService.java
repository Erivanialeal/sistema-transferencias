package br.com.erivania.sistema_transferencias.usuario.application.service;

import br.com.erivania.sistema_transferencias.usuario.application.api.UsuarioResponse;
import br.com.erivania.sistema_transferencias.usuario.application.api.UsuarioResquest;
import br.com.erivania.sistema_transferencias.usuario.application.repository.UsuarioRepository;
import br.com.erivania.sistema_transferencias.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class UsuarioApplicationService implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Override
    public void criarUsuario(UsuarioResquest usuarioResquest) {
        log.info("[inicia]UsuarioApplicationService - criarUsuario");
        Usuario usuario = new Usuario(usuarioResquest);
        usuario = usuarioRepository.salvar(usuario);
        log.info("[finaliza]UsuarioApplicationService - criarUsuario");
    }
}
