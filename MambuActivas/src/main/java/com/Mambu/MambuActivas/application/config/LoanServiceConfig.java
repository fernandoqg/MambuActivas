package com.Mambu.MambuActivas.application.config;

import com.Mambu.MambuActivas.domain.service.LoanService;
import com.Mambu.MambuActivas.infraestructure.LoanRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoanServiceConfig {

    @Bean
    public LoanService createLoan(){ return new LoanRepository();
    }
}
