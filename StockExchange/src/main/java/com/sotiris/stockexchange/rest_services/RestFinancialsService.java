package com.sotiris.stockexchange.rest_services;

import com.sotiris.stockexchange.clients.RestTemplateClient;
import com.sotiris.stockexchange.dtos.finnhub.financials.FinancialsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestFinancialsService {
    private final RestTemplateClient restTemplateClient;

    public FinancialsDTO getFinancials() {
        return restTemplateClient.fetchFinancials();
    }

}
