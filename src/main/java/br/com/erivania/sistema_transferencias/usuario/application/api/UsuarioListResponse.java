package br.com.erivania.sistema_transferencias.usuario.application.api;

import br.com.erivania.sistema_transferencias.usuario.domain.TipoUsuario;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
@Builder
public class UsuarioListResponse {
    @Id
    @GeneratedValue
    private UUID idUsuario;
    @NotBlank
    private String nome;
    @NotNull
    private BigDecimal saldo;
    private TipoUsuario tipoUsuario;
}
