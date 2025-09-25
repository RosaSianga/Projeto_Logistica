package br.com.senai.entregas;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@OpenAPIDefinition(info = @Info(
        title = "API de Logistica",
        version = "1.0",
        description = "API responsável por gerenciar os recursos de um sistema de logistica, como usuarios, veiculos e entregas."
))

public class EntregasApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntregasApplication.class, args);
	}

}
