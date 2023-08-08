package com.Mambu.MambuActivas.application.config;

import com.Mambu.MambuActivas.domain.service.RefinanceService;
import com.Mambu.MambuActivas.infraestructure.RefinanceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RefinanceServiceConfig {

    @Bean
    public RefinanceService refinance(){ return new RefinanceRepository();
    }
}
