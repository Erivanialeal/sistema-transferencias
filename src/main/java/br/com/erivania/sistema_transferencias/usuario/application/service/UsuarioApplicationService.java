package br.com.erivania.sistema_transferencias.usuario.application.service;

import br.com.erivania.sistema_transferencias.usuario.application.api.UsuarioListResponse;
import br.com.erivania.sistema_transferencias.usuario.application.api.UsuarioResponse;
import br.com.erivania.sistema_transferencias.usuario.application.api.UsuarioResquest;
import br.com.erivania.sistema_transferencias.usuario.application.repository.UsuarioRepository;
import br.com.erivania.sistema_transferencias.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class UsuarioApplicationService implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Override
    public UsuarioResponse criarUsuario(UsuarioResquest usuarioResquest) {
        log.info("[inicia]UsuarioApplicationService - criarUsuario");
        Usuario usuario = new Usuario(usuarioResquest);
         usuario = usuarioRepository.salvar(usuario);
        log.info("[finaliza]UsuarioApplicationService - criarUsuario");
        return UsuarioResponse.builder()
                .idUsuario(usuario.getIdUsuario())
                .build();

    }

    @Override
    public UsuarioResponse buscarUsuario(UUID idUsuario) {
        log.info("[inicia]UsuarioApplicationService - buscarUsuario");
        Usuario usuario = usuarioRepository.buscarUsuario(idUsuario);
        log.info("[finaliza]UsuarioApplicationService - buscarUsuario");
        return UsuarioResponse.builder()
                .idUsuario(usuario.getIdUsuario())
                .build();


    }

    @Override
    public List<UsuarioListResponse> buscarTodos() {
        log.info("[inicia]UsuarioApplicationService - buscarTodos");
        List<Usuario> usuarios = usuarioRepository.buscarTodos();
        log.info("[Finaliza]UsuarioApplicationService - buscarTodos");
        return usuarios.stream()
                .map(usuario -> UsuarioListResponse.builder()
                        .idUsuario(usuario.getIdUsuario())
                        .nome(usuario.getNome())
                        .tipoUsuario(usuario.getTipo())
                        .build())
                .toList();
    }
}
