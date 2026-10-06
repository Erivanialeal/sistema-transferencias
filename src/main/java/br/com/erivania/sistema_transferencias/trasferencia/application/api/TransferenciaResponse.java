package br.com.erivania.sistema_transferencias.trasferencia.application.api;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;
@Value
@Builder
public class TransferenciaResponse {
    @Id
    @GeneratedValue
    private UUID idTrasferencia;
    
}
