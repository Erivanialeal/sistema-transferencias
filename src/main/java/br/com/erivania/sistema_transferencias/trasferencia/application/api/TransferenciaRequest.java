package br.com.erivania.sistema_transferencias.trasferencia.application.api;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;
@Getter
@Setter
public class TransferenciaRequest {
    @NotNull
    private BigDecimal valor;
    @NotNull
    private UUID pagador;
    @NotNull
    private UUID recebedor;
}
