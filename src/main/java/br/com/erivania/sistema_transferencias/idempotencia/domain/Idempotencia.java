package br.com.erivania.sistema_transferencias.idempotencia.domain;

import br.com.erivania.sistema_transferencias.trasferencia.domain.Transferencia;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Idempotencia {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false,length = 100,unique = true)
    private String chave;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusIdepotencia status;
    @OneToOne
    @JoinColumn(name = "transferencia_id", unique = true)
    private Transferencia transferencia;

}
