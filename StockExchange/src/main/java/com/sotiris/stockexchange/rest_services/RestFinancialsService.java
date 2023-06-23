package com.sotiris.stockexchange.rest_services;

import com.sotiris.stockexchange.clients.RestTemplateClient;
import com.sotiris.stockexchange.dtos.finnhub.financials.FinancialsAsReportedDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestFinancialsService {
    private final RestTemplateClient restTemplateClient;

    public FinancialsAsReportedDTO getFinancials() {
        return restTemplateClient.showFinancialsAsReported();
    }

}
