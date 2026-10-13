package br.com.erivania.sistema_transferencias.idempotencia.application.repository;

import br.com.erivania.sistema_transferencias.idempotencia.domain.Idempotencia;

import java.util.Optional;

public interface IdempotenciaRepository{
    Optional<Idempotencia> buscarPorChave(String chave);
    Idempotencia salvar(Idempotencia idempotencia);
}
