package com.sotiris.stockexchange.rest_services;

import com.sotiris.stockexchange.clients.RestTemplateClient;
import com.sotiris.stockexchange.dtos.finnhub.filings.FilingsDTO;
import com.sotiris.stockexchange.dtos.finnhub.countries_metadata.CountriesMetadataDTO;
import com.sotiris.stockexchange.dtos.finnhub.financials.FinancialsDTO;
import com.sotiris.stockexchange.dtos.finnhub.market_news.MarketNewsDTO;
import com.sotiris.stockexchange.dtos.finnhub.patents.USPTOCompanyPatentsDTO;
import com.sotiris.stockexchange.dtos.finnhub.recommendation_trends.RecommendationTrendsDTO;
import com.sotiris.stockexchange.dtos.finnhub.social_sentiment.SocialSentimentResponseDTO;
import com.sotiris.stockexchange.dtos.finnhub.stocks.StockSymbolDTO;
import com.sotiris.stockexchange.dtos.finnhub.transactions.InsiderTransactionsDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;


@Service
@RequiredArgsConstructor
@Slf4j
public class RestStockService {
    private final RestTemplateClient restTemplateClient;

    public List<StockSymbolDTO> getStocks() {
        return restTemplateClient.fetchStocks();
    }

    public StockSymbolDTO getStockByName(String stock) {
        List<StockSymbolDTO> stocks = restTemplateClient.fetchStocks();
        for (StockSymbolDTO currentStock : stocks) {
            if (currentStock.description().equals(stock)) {
                return currentStock;
            }
        }
        throw new NoSuchElementException("The stock you search for does not exist!");
    }





    public List<String> getStocksInAlphabeticalOrder() {
        List<StockSymbolDTO> stocks = restTemplateClient.fetchStocks();
        List<String> sortedStocks = new ArrayList<>();


        for (StockSymbolDTO stock : stocks) {
            if (!stock.description().matches("^\\s*"))
                sortedStocks.add(stock.description().toUpperCase());
        }
        Collections.sort(sortedStocks);

        return sortedStocks;
    }

    public List<StockSymbolDTO> getStocksByType(String stockSymbol) {
        List<StockSymbolDTO> listOfTypes = new ArrayList<>();
        List<StockSymbolDTO> stocks = restTemplateClient.fetchStocks();
        for (StockSymbolDTO stock : stocks) {
            if (stock.type().equals(stockSymbol)) {
                listOfTypes.add(stock);
            }
        }
        return listOfTypes;
    }

    public int getNumberOfAllStocks() {
        return getStocksInAlphabeticalOrder().size();
    }

    public Map<String, String> getDescriptionAndTickerList() {
        Map<String, String> tickerAndDescription = new TreeMap<>();

        for (StockSymbolDTO stock : restTemplateClient.fetchStocks()) {
            if (!stock.description().matches("^\\s*"))
                tickerAndDescription.put(stock.description(), stock.symbol());
        }

        return tickerAndDescription;
    }

    public String showStockStats() {
        String stats = "";
        List<StockSymbolDTO> stocks = restTemplateClient.fetchStocks();
        Set<String> setOfStockTypes = new HashSet<>();
        Map<String, Integer> apparitionOfEachStockType = new TreeMap<>();
        int totalStocks = getNumberOfAllStocks();


        for (StockSymbolDTO stock : stocks) {

            if (apparitionOfEachStockType.containsKey(stock.type())) {
                apparitionOfEachStockType.put(stock.type(), apparitionOfEachStockType.get(stock.type()) + 1);
            } else {
                apparitionOfEachStockType.put(stock.type(), 1);
            }
            setOfStockTypes.add(stock.type());
        }

        stats = "Total number of stocks: " + totalStocks +
                "\nNumber of different stock types: " + apparitionOfEachStockType.size() +
                "\n\nTypes of stocks: " + setOfStockTypes +
                "\n\nNumber of apparitions for each stock type\n" +
                apparitionOfEachStockType;
        return stats;
    }

    public List<MarketNewsDTO> getMarketNews() {
        return restTemplateClient.fetchMarketNews();
    }

    public String getMarketHeadlines() {
        int counter=1;
        StringBuilder headlines = new StringBuilder();
        for(MarketNewsDTO news : getMarketNews()) {
            headlines.append("Headline number # "+counter+ " "+news.headline()).append("\n\n");
            counter++;
        }
        return headlines.toString();
    }

    public List<RecommendationTrendsDTO> getRecommendationTrends() {
        return restTemplateClient.fetchRecommendations();
    }


    public List<InsiderTransactionsDTO> getInsiderTransactions() {
        return restTemplateClient.fetchInsiderTransactions();
    }

    public FinancialsDTO getFinancialsAdReported() {
        return restTemplateClient.fetchFinancials();
    }

    public List<FilingsDTO> getFilings() {
        return restTemplateClient.fetchFilings();
    }

    public SocialSentimentResponseDTO getSocialSentiment(String symbol) {
        return restTemplateClient.fetchSocialSentiment(symbol);
    }

    public List<USPTOCompanyPatentsDTO> getUSPTOPatents() {
        return restTemplateClient.fetchUSPTOCompanyPatents();
    }

    public List<USPTOCompanyPatentsDTO> getUSASpendingActivities(){
        return restTemplateClient.fetchUSASpendingActivities();
    }

    public List<CountriesMetadataDTO> getCountriesMetadata(){
        return restTemplateClient.fetchCountriesMetadata();
    }


//    @Scheduled(fixedDelay = 2000)
    public void reportCurrentTime() throws InterruptedException {
        log.info("The time is now {}", LocalDateTime.now());
        Thread.sleep(6000);
        log.info("completed");
    }


}
