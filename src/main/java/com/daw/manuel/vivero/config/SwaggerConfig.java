package com.daw.manuel.vivero.config;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author manuelmc09
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket appiDocker() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.daw.manuel.vivero.controlers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    @Bean
    public ApiInfo getApiInfo() {
        return new ApiInfo("App Vivero Compra Online",
                "App Vivero Frutales Descripcion", "1.0",
                "http://localhost:9090/licence",
                new Contact("Manuel Macho", "http://mmc.es", "manuelmc09@mmc.es") {
        },
                "LICENCE", "http://localhost:9090/licence", Collections.emptyList());
    }
}
