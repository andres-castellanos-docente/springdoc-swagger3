package com.prueba.basedatos.configurations;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {


    @Bean
    public OpenAPI springShopOpenAPI() {
        Contact cont = new Contact();
        cont.setName("Andres Castellanos");
        cont.setEmail("andrescastellanosdocente@gmail.com");
        cont.setUrl("https://pruebaandres.com/");
        return new OpenAPI()
                .info(new Info().title("JPA API")
                        .description("Api Jpa Description")
                        .contact(cont)
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://pruebaandres.com/terms")))
                .externalDocs(new ExternalDocumentation()
                        .description("Prueba Andres Wiki Documentation")
                        .url("http://pruebaandres.com/terms/docs"));
    }
}
