package br.com.erivania.sistema_transferencias.trasferencia.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transferencia")
public interface TransferenciaAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.OK)
    TransferenciaResponse postTrasferencia(@Valid @RequestBody TransferenciaRequest transferenciaRequest);
}
