package br.com.erivania.sistema_transferencias.trasferencia.application.repository;

import br.com.erivania.sistema_transferencias.usuario.domain.Transferencia;

public interface TransferenciaRepository {
    Transferencia salvar(Transferencia transferencia);
}
