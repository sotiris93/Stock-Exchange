package com.sotiris.stockexchange.rest_services;

import com.sotiris.stockexchange.clients.RestTemplateClient;
import com.sotiris.stockexchange.dtos.finnhub.market_news.MarketNewsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestMarketNewsService {

    private final RestTemplateClient restTemplateClient;

    public List<MarketNewsDTO> getNews() {
        return restTemplateClient.showMarketNews();
    }
}
