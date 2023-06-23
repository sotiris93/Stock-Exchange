package com.sotiris.stockexchange.controllers;

import com.sotiris.stockexchange.model.MarketNews;
import com.sotiris.stockexchange.repositories.MarketNewsRepository;
import com.sotiris.stockexchange.rest_services.RestMarketNewsService;
import com.sotiris.stockexchange.services.MarketNewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("market")
public class MarketController {

    private final RestMarketNewsService restMarketNewsService;
    private final MarketNewsService marketNewsService;
    private final MarketNewsRepository marketNewsRepository;

    @GetMapping
    public ResponseEntity<List<MarketNews>> getAllNews() {
        return ResponseEntity.ok(marketNewsService.getMarketNews());
    }

    @GetMapping("/topNews")
    public ResponseEntity<List<MarketNews>> getTopNews() {
        return ResponseEntity.ok(marketNewsRepository.findOnlyTheTopNews());
    }

    @GetMapping("/top10News")
    public ResponseEntity<List<MarketNews>> getLatestTop10News() {
        return ResponseEntity.ok(marketNewsRepository.findLatestTop10News());
    }

    @GetMapping("/marketWatchNews")
    public ResponseEntity<List<MarketNews>> getMarketWatchNews() {
        return ResponseEntity.ok(marketNewsRepository.findMarketWatchNews());
    }

    @GetMapping("/CNBCNews")
    public ResponseEntity<List<MarketNews>> getCNBCNews() {
        return ResponseEntity.ok(marketNewsRepository.findCNBCNews());
    }
}