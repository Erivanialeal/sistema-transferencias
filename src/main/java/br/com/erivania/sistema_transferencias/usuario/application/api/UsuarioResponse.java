package br.com.erivania.sistema_transferencias.usuario.application.api;

import br.com.erivania.sistema_transferencias.usuario.domain.TipoUsuario;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class UsuarioResponse {
    private String nome;
    private String email;
    private TipoUsuario tipo;
    private BigDecimal saldo;

}
