package com.sotiris.stockexchange.rest_services;

import com.sotiris.stockexchange.clients.RestTemplateClient;
import com.sotiris.stockexchange.dtos.finnhub.earnings.EarningsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestEarningsService {

    private final RestTemplateClient restTemplateClient;

    public List<EarningsDTO> getEarnings(String symbol) {
        return restTemplateClient.fetchEarnings(symbol);
    }
}
