package com.Mambu.MambuActivas.application.config;

import com.Mambu.MambuActivas.domain.service.DisbursementService;
import com.Mambu.MambuActivas.domain.service.FullPaymentService;
import com.Mambu.MambuActivas.infraestructure.DisbursementRepository;
import com.Mambu.MambuActivas.infraestructure.FullPaymentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FullPaymentConfig {

    @Bean
    public FullPaymentService paymentService(){ return new FullPaymentRepository();
    }
}
