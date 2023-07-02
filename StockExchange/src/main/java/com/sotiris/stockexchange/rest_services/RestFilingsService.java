package com.sotiris.stockexchange.rest_services;

import com.sotiris.stockexchange.clients.RestTemplateClient;
import com.sotiris.stockexchange.dtos.finnhub.filings.FilingsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestFilingsService {
    private final RestTemplateClient restTemplateClient;

    public List<FilingsDTO> getFilings() {
        return restTemplateClient.fetchFilings();
    }
}
