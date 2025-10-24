package com.transports.transport.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Transport Management API",
                version = "1.0.0",
                description = "API documentation for Transport Management System",
                contact = @Contact(
                        name = "Youssef Elhoubi",
                        email = "elhoubiyoussef@matcontactinish.marouk"
                ),
                license = @License(name = "makinash", url = "https://www.apache.org/licenses/LICENSE-2.0.html")
        )
)
public class SwaggerConfig{
}
