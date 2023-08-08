package com.Mambu.MambuActivas.application.config;

import com.Mambu.MambuActivas.domain.service.ProductService;
import com.Mambu.MambuActivas.infraestructure.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductServiceConfig {
    @Bean
    public ProductService productResponse(){ return new ProductRepository();
    }
}
