package br.com.erivania.sistema_transferencias.usuario.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Idepotencia {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false,length = 100)
    private String chave;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusIdepotencia status;
    @OneToOne
    @JoinColumn(name = "transferencia_id", unique = true)
    private Transferencia transferencia;

}
