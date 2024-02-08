package com.enviro.assessment.grad001.siyathandazamqhamane.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;


@Configuration
@OpenAPIDefinition(
        info =
            @Info(
                    title = "Investment service",
                    version = "v1",
                    description = "Withdrawal notice process for investors"))
public class SwaggerConfig {}
