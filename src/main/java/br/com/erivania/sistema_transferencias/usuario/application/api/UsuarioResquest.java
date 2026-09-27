package br.com.erivania.sistema_transferencias.usuario.application.api;

import br.com.erivania.sistema_transferencias.usuario.domain.TipoUsuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UsuarioResquest {
    @NotBlank
    private String nome;
    @NotBlank
    @Pattern(regexp = "\\d{11}")
    private String cpf;
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 8)
    private String senha;
    private TipoUsuario tipo;
    @NotNull
    private BigDecimal saldo;
}
