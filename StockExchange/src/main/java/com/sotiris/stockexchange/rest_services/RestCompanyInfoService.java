package com.sotiris.stockexchange.rest_services;

import com.sotiris.stockexchange.clients.RestTemplateClient;
import com.sotiris.stockexchange.dtos.finnhub.companies.CompanyInfoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestCompanyInfoService {
    private final RestTemplateClient restTemplateClient;

    public CompanyInfoDTO getCompanyInfo(String symbol) {
        if (symbol == null || symbol.isBlank()) {
            throw new IllegalArgumentException();
        }
        return restTemplateClient.fetchCompanyProfileInfo(symbol);
    }
}
