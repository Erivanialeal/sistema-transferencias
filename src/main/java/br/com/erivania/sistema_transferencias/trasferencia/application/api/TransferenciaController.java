package br.com.erivania.sistema_transferencias.trasferencia.application.api;

import br.com.erivania.sistema_transferencias.trasferencia.application.service.TransferenciaService;
import br.com.erivania.sistema_transferencias.usuario.application.api.UsuarioResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class TransferenciaController implements TransferenciaAPI {
    private final TransferenciaService trasferenciaService;

    @Override
    public TransferenciaResponse postTrasferencia(TransferenciaRequest transferenciaRequest) {
        log.info("[inicia]TransferenciaController -  postTrasferencia");
        TransferenciaResponse transferencia = trasferenciaService.fazerTrasferencia();
        log.info("[inicia]TransferenciaController -  postTrasferencia");
        return transferencia;
    }
}
