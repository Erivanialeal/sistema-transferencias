package br.com.erivania.sistema_transferencias.usuario.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transferencia {
    @GeneratedValue
    @Id
    private UUID idTransferencia;
    @NotNull
    private BigDecimal valor;
    @ManyToOne
    @JoinColumn(name = "pagador_id")
    private Usuario pagador;
    @ManyToOne
    @JoinColumn(name = "recebedor_id")
    private Usuario recebedor;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime data;
    private String idempotencyKey;

}
