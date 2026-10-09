package br.com.erivania.sistema_transferencias.trasferencia.application.api;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;
@Value
@Builder
@Transactional
public class TransferenciaResponse {
    @Id
    @GeneratedValue
    private UUID idTrasferencia;
    
}
