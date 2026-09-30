package br.com.erivania.sistema_transferencias.usuario.application.api;

import br.com.erivania.sistema_transferencias.usuario.domain.TipoUsuario;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
@Builder
public class UsuarioResponse {
    @Id
    @GeneratedValue
    private UUID idUsuario;

}
