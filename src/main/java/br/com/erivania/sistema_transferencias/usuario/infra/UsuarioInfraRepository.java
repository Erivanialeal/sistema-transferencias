package br.com.erivania.sistema_transferencias.usuario.infra;

import br.com.erivania.sistema_transferencias.handler.APIException;
import br.com.erivania.sistema_transferencias.usuario.application.repository.UsuarioRepository;
import br.com.erivania.sistema_transferencias.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class UsuarioInfraRepository implements UsuarioRepository {
    private  final UsuarioSpringDataJPARepository usuarioSpringDataJPARepository;
    @Override
    public Usuario salvar(Usuario usuario) {
        log.info("[Inicia]UsuarioInfraRepository - salvar");
        usuarioSpringDataJPARepository.save(usuario);
        log.info("[Fnaliza]UsuarioInfraRepository - salvar");
        return usuario;
    }

    @Override
    public Usuario buscarUsuario(UUID idUsuario) {
        log.info("[Inicia]UsuarioInfraRepository - buscarUsuario");
        Usuario usuario = usuarioSpringDataJPARepository.findById(idUsuario)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND,"Usuario não encontrado!"));
        log.info("[finaliza]UsuarioInfraRepository - buscarUsuario");
        return usuario;
    }

}
