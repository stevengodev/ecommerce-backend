package com.foliaco.user_service.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "OpenAPIDefinition",
                description = "Api de gestion de usuarios",
                version = "1.0",
                contact = @Contact(
                        name = "Foliaco Company",
                        url = "https://github.com/stevengodev",
                        email = "stevengodev@gmail.com"
                )
        )
)
public class OpenApiConfig {

}
