package com.co.lineadevida.apirest.configuration;

//url localhost:8082/swagger-ui.html#/Persona
//localhost:8082/v2/api-docs

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api (){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .pathMapping("/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Api de Prueba Proyecto Ciclo3",
                "Ejemplos de Uso Metodos Http",
                "API V 0.0.1",
                "Politicas de uso",
                new Contact("Grupos 15-16", "www.grupos15-16.com", "noreply@grupos15-16.com"),
                "Licencia Libre academica", "API license URL", Collections.emptyList());
    }
}
