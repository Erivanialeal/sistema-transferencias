package br.com.erivania.sistema_transferencias.usuario.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private UUID idUsuario;
    @NotBlank
    private String nome;
    @NotBlank
    @Pattern(regexp = "//d{11}")
    private String cpf;
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 8)
    private String senha;
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;
    @NotNull
    private BigDecimal saldo;
    @OneToMany(mappedBy = "pagador")
    private List<Transferencia> transferenciaEnviadas;
    @OneToMany(mappedBy = "recebedor")
    private  List<Transferencia> transferenciaRecebida;
}
