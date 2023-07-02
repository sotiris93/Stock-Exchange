package com.sotiris.stockexchange.controllers;

import com.sotiris.stockexchange.dtos.finnhub.filings.FilingsDTO;
import com.sotiris.stockexchange.dtos.finnhub.countries_metadata.CountriesMetadataDTO;
import com.sotiris.stockexchange.dtos.finnhub.earnings.EarningsDTO;
import com.sotiris.stockexchange.dtos.finnhub.financials.FinancialsDTO;
import com.sotiris.stockexchange.dtos.finnhub.market_news.MarketNewsDTO;
import com.sotiris.stockexchange.dtos.finnhub.patents.USPTOCompanyPatentsDTO;
import com.sotiris.stockexchange.dtos.finnhub.recommendation_trends.RecommendationTrendsDTO;
import com.sotiris.stockexchange.dtos.finnhub.social_sentiment.SocialSentimentResponseDTO;
import com.sotiris.stockexchange.dtos.finnhub.stocks.StockSymbolDTO;
import com.sotiris.stockexchange.dtos.finnhub.transactions.InsiderTransactionsDTO;
import com.sotiris.stockexchange.model.Company;
import com.sotiris.stockexchange.rest_services.RestStockService;
import com.sotiris.stockexchange.services.CompanyService;
import com.sotiris.stockexchange.services.EarningsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("stocks")
public class StockController {


    private final RestStockService restStockService;
    private final CompanyService companyService;
    private final EarningsService earningsService;


    @GetMapping
    public List<Company> getStocks() {
        return companyService.getAllCompaniesInfo();
    }

    @GetMapping("/{name}")
    public ResponseEntity<StockSymbolDTO> showStockInfoByName(@PathVariable String name) {
        return ResponseEntity.ok(restStockService.getStockByName(name));
    }

    @GetMapping("/sortedStocks")
    public ResponseEntity<List<String>> getSortedStocks() {
        return ResponseEntity.ok(restStockService.getStocksInAlphabeticalOrder());
    }

    @GetMapping("/symbols/{stockType}")
    public ResponseEntity<List<StockSymbolDTO>> getStocksSymbols(@PathVariable String stockType) {
        return ResponseEntity.ok(restStockService.getStocksByType(stockType));
    }

    @GetMapping("/total")
    public ResponseEntity<Integer> getTotalStocksAvailable() {
        return ResponseEntity.ok(restStockService.getNumberOfAllStocks());
    }

    @GetMapping("/tickerAndDescription")
    public ResponseEntity<Map<String, String>> showTickerAndDescription() {
        return ResponseEntity.ok(restStockService.getDescriptionAndTickerList());
    }

    @GetMapping("/stats")
    public ResponseEntity<String> getStockStats() {
        return ResponseEntity.ok(restStockService.showStockStats());
    }

    @GetMapping("/marketNews")
    public ResponseEntity<List<MarketNewsDTO>> getStockMarketNews() {
        return ResponseEntity.ok(restStockService.getMarketNews());
    }

    @GetMapping("/headlines")
    public ResponseEntity<String > getHeadlines() {
        return ResponseEntity.ok(restStockService.getMarketHeadlines());
    }

    @GetMapping("/trends")
    public ResponseEntity<List<RecommendationTrendsDTO>> getRecommendationTrends() {
        return ResponseEntity.ok(restStockService.getRecommendationTrends());
    }

    @GetMapping("/earningsCalendar")
    public ResponseEntity<List<EarningsDTO>> getEarningsCalendar() {
        return ResponseEntity.ok(earningsService.getEarnings());
    }

    @GetMapping("/insiderTransactions")
    public ResponseEntity<List<InsiderTransactionsDTO>> getInsiderTransactions() {
        return ResponseEntity.ok(restStockService.getInsiderTransactions());
    }

    @GetMapping("/financials")
    public ResponseEntity<FinancialsDTO> getFinancials() {
        return ResponseEntity.ok(restStockService.getFinancialsAdReported());
    }

    @GetMapping("/filings")
    public ResponseEntity<List<FilingsDTO>> getFilings() {
        return ResponseEntity.ok(restStockService.getFilings());
    }

    @GetMapping("/socialSentiment")
    public ResponseEntity<SocialSentimentResponseDTO> getSocialSentiment(String symbol) {
        return ResponseEntity.ok(restStockService.getSocialSentiment(symbol));
    }

    @GetMapping("/patents")
    public ResponseEntity<List<USPTOCompanyPatentsDTO>> getUSPTOPatents() {
        return ResponseEntity.ok(Collections.singletonList(restStockService.getUSPTOPatents()));
    }

    @GetMapping("/USASpendingActivities")
    public ResponseEntity<List<USPTOCompanyPatentsDTO>> getUSASpendingActivities() {
        return ResponseEntity.ok(restStockService.getUSASpendingActivities());
    }

    @GetMapping("/countriesMetadata")
    public ResponseEntity<List<CountriesMetadataDTO>> getCountriesMetadata() {
        return ResponseEntity.ok(restStockService.getCountriesMetadata());
    }
}
