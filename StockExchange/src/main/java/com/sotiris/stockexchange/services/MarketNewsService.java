package com.sotiris.stockexchange.services;

import com.sotiris.stockexchange.dtos.finnhub.market_news.MarketNewsDTO;
import com.sotiris.stockexchange.model.MarketNews;
import com.sotiris.stockexchange.repositories.MarketNewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MarketNewsService {

    private final MarketNewsRepository marketNewsRepository;

public void createMarketNews(List<MarketNewsDTO> marketNewsDTOS) {

    List<MarketNews> marketNews = new ArrayList<>();

    for(MarketNewsDTO marketNewsDTO: marketNewsDTOS) {
        marketNews.add(new MarketNews(marketNewsDTO.category(),  marketNewsDTO.datetime(), marketNewsDTO.headline(),
                marketNewsDTO.image(), marketNewsDTO.related(), marketNewsDTO.source(),
                marketNewsDTO.summary(), marketNewsDTO.url()));
    }
    marketNewsRepository.saveAll(marketNews);
}

public List<MarketNews> getMarketNews() {
    return marketNewsRepository.findAll();
}
}
