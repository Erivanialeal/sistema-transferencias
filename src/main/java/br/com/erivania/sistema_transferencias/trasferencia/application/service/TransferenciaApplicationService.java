package br.com.erivania.sistema_transferencias.trasferencia.application.service;

import br.com.erivania.sistema_transferencias.trasferencia.application.api.TransferenciaResponse;
import br.com.erivania.sistema_transferencias.usuario.application.api.UsuarioResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class TransferenciaApplicationService implements TransferenciaService {

    @Override
    public TransferenciaResponse fazerTrasferencia() {
        log.info("[Finaliza]TransferenciaApplicationService - fazerTrasferencia");
        log.info("[Finaliza]TransferenciaApplicationService - fazerTrasferencia");

        return null;
    }
}
