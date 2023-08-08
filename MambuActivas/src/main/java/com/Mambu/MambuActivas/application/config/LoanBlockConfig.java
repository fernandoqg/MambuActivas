package com.Mambu.MambuActivas.application.config;

import com.Mambu.MambuActivas.domain.service.LoanBlockService;
import com.Mambu.MambuActivas.infraestructure.LoanBlockRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoanBlockConfig {

    @Bean
    public LoanBlockService block(){ return new LoanBlockRepository();
    }
}
