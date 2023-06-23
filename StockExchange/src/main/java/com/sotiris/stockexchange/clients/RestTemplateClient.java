package com.sotiris.stockexchange.clients;


import com.sotiris.stockexchange.dtos.finnhub.filings.FilingsDTO;
import com.sotiris.stockexchange.dtos.finnhub.companies.CompanyInfoDTO;
import com.sotiris.stockexchange.dtos.finnhub.countries_metadata.CountriesMetadataDTO;
import com.sotiris.stockexchange.dtos.finnhub.earnings.EarningsDTO;
import com.sotiris.stockexchange.dtos.finnhub.earnings.EarningsResponse;
import com.sotiris.stockexchange.dtos.finnhub.financials.FinancialsDTO;
import com.sotiris.stockexchange.dtos.finnhub.market_news.MarketNewsDTO;
import com.sotiris.stockexchange.dtos.finnhub.patents.USPTOCompanyPatentsDTO;
import com.sotiris.stockexchange.dtos.finnhub.recommendation_trends.RecommendationTrendsDTO;
import com.sotiris.stockexchange.dtos.finnhub.social_sentiment.SocialSentimentResponseDTO;
import com.sotiris.stockexchange.dtos.finnhub.stocks.StockSymbolDTO;
import com.sotiris.stockexchange.dtos.finnhub.transactions.InsiderTransactionsDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.*;


@Service
public class RestTemplateClient {

    private final String accessToken;

    private final RestTemplate restTemplate;

    LocalDate today = LocalDate.now();

    public RestTemplateClient(@Value("${access-token}") String accessToken, RestTemplateBuilder restTemplateBuilder) {
        this.accessToken = accessToken;
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<StockSymbolDTO> getStocks() {
        String url = "https://finnhub.io/api/v1/stock/symbol";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Finnhub-Token", accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("exchange", "{exchange}")
                .encode()
                .toUriString();

        Map<String, String> params = Map.of("exchange", "US");

        HttpEntity<StockSymbolDTO[]> response = restTemplate.exchange(
                urlTemplate,
                HttpMethod.GET,
                entity,
                StockSymbolDTO[].class,
                params
        );

        return response.getBody() == null ? Collections.emptyList() : List.of(response.getBody());
    }

    public CompanyInfoDTO getCompanyProfileInfo(String symbol) {
        String url = "https://finnhub.io/api/v1/stock/profile2";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Finnhub-Token", accessToken);
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("symbol", symbol)
                .encode()
                .toUriString();

        HttpEntity<CompanyInfoDTO> response = restTemplate.exchange(
                urlTemplate,
                HttpMethod.GET,
                entity,
                CompanyInfoDTO.class
        );


        System.out.println(response.getBody());
        return response.getBody();

    }

    public List<MarketNewsDTO> showMarketNews() {
        String url = "https://finnhub.io/api/v1/news?category=general";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Finnhub-Token", accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(url)
                .encode()
                .toUriString();

        Map<String, String> params = new HashMap<>();
        params.put("category", "general");


        HttpEntity<MarketNewsDTO[]> response = restTemplate.exchange(
                urlTemplate,
                HttpMethod.GET,
                entity,
                MarketNewsDTO[].class

        );

        System.out.println(response.getBody());
        return response.getBody() == null ? Collections.emptyList() : List.of(response.getBody());
    }

    public List<RecommendationTrendsDTO> showRecommendations() {
        String url = "https://finnhub.io/api/v1/stock/recommendation";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Finnhub-Token", accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("symbol", "{symbol}")
                .encode()
                .toUriString();

        Map<String, String> params = Map.of("symbol", "AAPL");


        HttpEntity<RecommendationTrendsDTO[]> response = restTemplate.exchange(
                urlTemplate,
                HttpMethod.GET,
                entity,
                RecommendationTrendsDTO[].class,
                params

        );

        System.out.println(response.getBody());
        return response.getBody() == null ? Collections.emptyList() : List.of(response.getBody());
    }

    public List<EarningsDTO> getEarnings(String symbol) {

        String url = "https://finnhub.io/api/v1/calendar/earnings";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Finnhub-Token", accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("symbol", symbol)
                .encode()
                .toUriString();


        HttpEntity<EarningsResponse> response = restTemplate.exchange(
                urlTemplate,
                HttpMethod.GET,
                entity,
                EarningsResponse.class
        );

        System.out.println(response.getHeaders());
        return response.getBody() != null ? response.getBody().earningsDTOS() : Collections.emptyList();
    }



    public List<InsiderTransactionsDTO> showInsiderTransactions() {
        String url = "https://finnhub.io/api/v1/stock/insider-transactions";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Finnhub-Token", accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(url)
                .encode()
                .toUriString();

        HttpEntity<InsiderTransactionsDTO> response = restTemplate.exchange(
                urlTemplate,
                HttpMethod.GET,
                entity,
                InsiderTransactionsDTO.class
        );

        System.out.println(response.getBody());
        return response.getBody() == null ? Collections.emptyList() : List.of(response.getBody());
    }



    public FinancialsDTO fetchFinancials() {
        String url = "https://finnhub.io/api/v1/stock/financials-reported?symbol=AAPL";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Finnhub-Token", accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(url)
                .encode()
                .toUriString();

        HttpEntity<FinancialsDTO> response = restTemplate.exchange(
                urlTemplate,
                HttpMethod.GET,
                entity,
                FinancialsDTO.class
        );

        System.out.println(response.getBody());
        return response.getBody();
    }



    public List<FilingsDTO> showFilings() {
        String url = "https://finnhub.io/api/v1/stock/filings";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Finnhub-Token", accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(url)
                .encode()
                .toUriString();

        HttpEntity<FilingsDTO[]> response = restTemplate.exchange(
                urlTemplate,
                HttpMethod.GET,
                entity,
                FilingsDTO[].class
        );

        System.out.println(response.getBody());
        return response.getBody() == null ? Collections.emptyList() : List.of(response.getBody());
    }


    public SocialSentimentResponseDTO showSocialSentiment(String symbol) {
        String url = "https://finnhub.io/api/v1/stock/social-sentiment";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Finnhub-Token", accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("symbol", symbol)
                .encode()
                .toUriString();

        HttpEntity<SocialSentimentResponseDTO> response = restTemplate.exchange(
                urlTemplate,
                HttpMethod.GET,
                entity,
                SocialSentimentResponseDTO.class
        );

        System.out.println(response.getBody());
        return response.getBody();
    }



    public List<USPTOCompanyPatentsDTO> showUSPTOCompanyPatents() { // PROVLIMA STO PEDIO COMPANYFILINGNAME
        String url = "https://finnhub.io/api/v1//stock/uspto-patent?symbol=NVDA&from=2021-01-01&to="+today;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Finnhub-Token", accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("symbol", "{symbol}")
                .encode()
                .toUriString();

        Map<String, String> params = Map.of("symbol", "AAPL");


        HttpEntity<USPTOCompanyPatentsDTO> response = restTemplate.exchange(
                urlTemplate,
                HttpMethod.GET,
                entity,
                USPTOCompanyPatentsDTO.class,
                params
        );

        System.out.println(response.getBody());
        return response.getBody() == null ? Collections.emptyList() : List.of(response.getBody());
    }


    /*
    This dataset can help you identify companies that win big government contracts which
     is extremely important for industries such as Defense, Aerospace, and Education.
     */
    public List<USPTOCompanyPatentsDTO> showUSASpendingActivities() { // OLA NULL
        String url = "https://finnhub.io/api/v1/stock/usa-spending?symbol=AAPL&from=2021-01-01&to="+today;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Finnhub-Token", accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("symbol", "{symbol}")
                .encode()
                .toUriString();

        Map<String, String> params = Map.of("symbol", "AAPL");


        HttpEntity<USPTOCompanyPatentsDTO> response = restTemplate.exchange(
                urlTemplate,
                HttpMethod.GET,
                entity,
                USPTOCompanyPatentsDTO.class,
                params
        );

        System.out.println(response.getBody());
        return response.getBody() == null ? Collections.emptyList() : List.of(response.getBody());
    }

    public List<CountriesMetadataDTO> showCountriesMetadata() {
        String url = "https://finnhub.io/api/v1/country";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Finnhub-Token", accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("symbol", "{symbol}")
                .encode()
                .toUriString();

        Map<String, String> params = Map.of("symbol", "AAPL");


        HttpEntity<CountriesMetadataDTO[]> response = restTemplate.exchange(
                urlTemplate,
                HttpMethod.GET,
                entity,
                CountriesMetadataDTO[].class,
                params
        );

        System.out.println(response.getBody());
        return response.getBody() == null ? Collections.emptyList() : List.of(response.getBody());
    }

}
