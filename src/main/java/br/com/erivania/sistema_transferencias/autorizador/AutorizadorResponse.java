package br.com.erivania.sistema_transferencias.autorizador;

public record AutorizadorResponse(
        String status,
        DadosAutorizacao data
){
    public record DadosAutorizacao(
            boolean authorization

    ){
    }

}
