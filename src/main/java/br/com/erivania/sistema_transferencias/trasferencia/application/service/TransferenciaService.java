package br.com.erivania.sistema_transferencias.trasferencia.application.service;

import br.com.erivania.sistema_transferencias.trasferencia.application.api.TransferenciaRequest;
import br.com.erivania.sistema_transferencias.trasferencia.application.api.TransferenciaResponse;
import br.com.erivania.sistema_transferencias.usuario.application.api.UsuarioResponse;

public interface TransferenciaService {
    TransferenciaResponse fazerTrasferencia(String idempoteceKey,TransferenciaRequest transferenciaRequest);
}
