package com.Mambu.MambuActivas.application.config;

import com.Mambu.MambuActivas.domain.service.DisbursementService;
import com.Mambu.MambuActivas.domain.service.LoanService;
import com.Mambu.MambuActivas.infraestructure.DisbursementRepository;
import com.Mambu.MambuActivas.infraestructure.LoanRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DisbursementConfig {
    @Bean
    public DisbursementService disbursement(){ return new DisbursementRepository();
    }
}
