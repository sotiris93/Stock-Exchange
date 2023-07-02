package com.sotiris.stockexchange.rest_services;

import com.sotiris.stockexchange.clients.RestTemplateClient;
import com.sotiris.stockexchange.dtos.finnhub.patents.USPTOCompanyPatentsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestUSPTOCompanyPatents {

    private final RestTemplateClient restTemplateClient;
    public USPTOCompanyPatentsDTO fetchUSPTOCompanyPatents() {
        return restTemplateClient.fetchUSPTOCompanyPatents();
    }
}
