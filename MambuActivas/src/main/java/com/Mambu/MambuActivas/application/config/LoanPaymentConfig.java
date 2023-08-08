package com.Mambu.MambuActivas.application.config;

import com.Mambu.MambuActivas.domain.service.DisbursementService;
import com.Mambu.MambuActivas.domain.service.LoanPaymentService;
import com.Mambu.MambuActivas.infraestructure.DisbursementRepository;
import com.Mambu.MambuActivas.infraestructure.LoanPaymentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoanPaymentConfig {

    @Bean
    public LoanPaymentService payment(){ return new LoanPaymentRepository();
    }
}
