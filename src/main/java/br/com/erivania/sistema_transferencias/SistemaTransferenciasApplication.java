package br.com.erivania.sistema_transferencias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SistemaTransferenciasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaTransferenciasApplication.class, args);
	}

}
