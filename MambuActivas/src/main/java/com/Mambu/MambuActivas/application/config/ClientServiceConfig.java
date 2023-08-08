package com.Mambu.MambuActivas.application.config;

import com.Mambu.MambuActivas.domain.service.ClientService;
import com.Mambu.MambuActivas.infraestructure.ClientRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientServiceConfig {
    @Bean
    public ClientService clientService(){ return new ClientRepository();
    }
}
