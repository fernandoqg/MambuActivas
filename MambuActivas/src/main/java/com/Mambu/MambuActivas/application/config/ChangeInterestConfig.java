package com.Mambu.MambuActivas.application.config;

import com.Mambu.MambuActivas.domain.service.ApproveLoanService;
import com.Mambu.MambuActivas.domain.service.ChangeInterestService;
import com.Mambu.MambuActivas.infraestructure.ApproveLoanRepository;
import com.Mambu.MambuActivas.infraestructure.ChangeInterestRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChangeInterestConfig {

    @Bean
    public ChangeInterestService change(){ return new ChangeInterestRepository();
    }

}
