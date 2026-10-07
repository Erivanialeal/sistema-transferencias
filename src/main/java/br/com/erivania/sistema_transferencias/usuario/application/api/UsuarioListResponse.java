package br.com.erivania.sistema_transferencias.usuario.application.api;

import br.com.erivania.sistema_transferencias.usuario.domain.TipoUsuario;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class UsuarioListResponse {
    @Id
    @GeneratedValue
    private UUID idUsuario;
    @NotBlank
    private String nome;
    private TipoUsuario tipoUsuario;
}
