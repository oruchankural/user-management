package com.usermanagement.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.usermanagement.infrastructure.persistence")
@ComponentScan("com.usermanagement.infrastructure.services.concrete")
public class AppConfig {

}
