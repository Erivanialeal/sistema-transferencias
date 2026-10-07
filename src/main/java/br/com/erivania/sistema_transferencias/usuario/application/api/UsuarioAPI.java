package br.com.erivania.sistema_transferencias.usuario.application.api;

import br.com.erivania.sistema_transferencias.trasferencia.application.api.TransferenciaRequest;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/usuario")
public interface UsuarioAPI {

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<UsuarioListResponse> getListUsuario();

    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    UsuarioResponse postUsuario(@Valid @RequestBody UsuarioResquest usuarioResquest);

    @GetMapping("/{idUsuario}")
    @ResponseStatus(code = HttpStatus.OK)
    UsuarioResponse getUsuario(@PathVariable UUID idUsuario);
}
