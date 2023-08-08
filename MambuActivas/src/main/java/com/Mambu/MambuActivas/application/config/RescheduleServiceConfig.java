package com.Mambu.MambuActivas.application.config;

import com.Mambu.MambuActivas.domain.service.RefinanceService;
import com.Mambu.MambuActivas.domain.service.RescheduleService;
import com.Mambu.MambuActivas.infraestructure.RefinanceRepository;
import com.Mambu.MambuActivas.infraestructure.RescheduleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RescheduleServiceConfig {

    @Bean
    public RescheduleService reschedule(){ return new RescheduleRepository();
    }
}
