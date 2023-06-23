package com.sotiris.stockexchange.configurations;

import com.sotiris.stockexchange.dtos.CompanyDTO;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Collections;

@Configuration
public class CompanyDTOConfiguration {


    @Bean
    @ConditionalOnProperty(name = "abc", havingValue = "d", matchIfMissing = true)
    public CompanyDTO companyDTO5() {
        return new CompanyDTO(2L, "abcd", Collections.emptyList());
    }

    @Profile("sotiris1")
    @Bean
    public CompanyDTO sotiris() {
        return new CompanyDTO(1L, "abc", Collections.emptyList());
    }
}
