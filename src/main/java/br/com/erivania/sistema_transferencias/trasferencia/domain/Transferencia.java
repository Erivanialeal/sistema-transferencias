package br.com.erivania.sistema_transferencias.trasferencia.domain;

import br.com.erivania.sistema_transferencias.usuario.domain.Status;
import br.com.erivania.sistema_transferencias.usuario.domain.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
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

}
