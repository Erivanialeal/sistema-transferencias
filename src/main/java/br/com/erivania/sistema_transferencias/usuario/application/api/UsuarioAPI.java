package br.com.erivania.sistema_transferencias.usuario.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario")
public interface UsuarioAPI {

    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    UsuarioResponse postUsuario(@Valid @RequestBody UsuarioResquest usuarioResquest);
}
