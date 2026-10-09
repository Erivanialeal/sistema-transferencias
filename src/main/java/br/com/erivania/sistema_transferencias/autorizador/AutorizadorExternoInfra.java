package br.com.erivania.sistema_transferencias.autorizador;

import br.com.erivania.sistema_transferencias.handler.APIException;
import lombok.extern.log4j.Log4j2;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@Log4j2
public class AutorizadorExternoInfra implements AutorizadorExterno{
    private  final RestClient restClient;

    public AutorizadorExternoInfra(RestClient.Builder builder){
        this.restClient = builder
                .baseUrl("https://util.devi.tools")
                .build();
    }
    @Override
    public boolean autorizar() {
        log.info("[Inicia] AutorizadorExternoInfra - autorizar");
        AutorizadorResponse response = restClient.get()
                .uri("/api/v2/authorize")
                .retrieve()
                .body(AutorizadorResponse.class);
        if (response == null || response.data() == null) {
            throw APIException.build(
                    HttpStatus.BAD_GATEWAY,
                    "Resposta inválida do autorizador externo"
            );
        }
        boolean autorizado = response.data().authorization();
        log.info("Resultado da autorização externa: {}", autorizado);
        log.info("[Finaliza] AutorizadorExternoInfra - autorizar");
        return autorizado;

    }
}
