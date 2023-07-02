//package com.sotiris.stockexchange;
//
//import com.sotiris.stockexchange.dtos.finnhub.companies.CompanyInfoDTO;
//import com.sotiris.stockexchange.dtos.finnhub.earnings.EarningsDTO;
//import com.sotiris.stockexchange.dtos.finnhub.filings.FilingsDTO;
//import com.sotiris.stockexchange.dtos.finnhub.financials.FinancialsDTO;
//import com.sotiris.stockexchange.dtos.finnhub.market_news.MarketNewsDTO;
//import com.sotiris.stockexchange.dtos.finnhub.patents.USPTOCompanyPatentsDTO;
//import com.sotiris.stockexchange.dtos.finnhub.social_sentiment.SocialSentimentResponseDTO;
//import com.sotiris.stockexchange.dtos.finnhub.stocks.StockSymbolDTO;
//import com.sotiris.stockexchange.rest_services.*;
//import com.sotiris.stockexchange.services.*;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//@RequiredArgsConstructor
//@Slf4j
//public class MyApplicationRunner implements ApplicationRunner {
//
//    private final RestStockService restStockService;
//    private final StockService stockService;
//    private final RestCompanyInfoService restCompanyInfoService;
//    private final CompanyService companyService;
//    private final RestMarketNewsService restMarketNewsService;
//    private final MarketNewsService marketNewsService;
//    private final RestEarningsService restEarningsService;
//    private final EarningsService earningsService;
//    private final RestFinancialsService restFinancialsService;
//    private final FinancialsService financialsService;
//    private final RestSocialSentimentService restSocialSentimentService;
//    private final SocialSentimentService socialSentimentService;
//    private  final RestFilingsService restFilingsService;
//    private final FilingsService filingsService;
//    private final RestUSPTOCompanyPatents restUSPTOCompanyPatents;
//    private final USPTOCompanyPatentsService usptoCompanyPatentsService;
//
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        List<StockSymbolDTO> stockSymbolDTOS =  restStockService.getStocks();
//        stockService.createStocks(stockSymbolDTOS);
////
//        CompanyInfoDTO companyInfoDTO = restCompanyInfoService.getCompanyInfo("AAPL");
//        companyService.createCompany(companyInfoDTO);
////
//        List<MarketNewsDTO> marketNewsDTO = restMarketNewsService.getNews();
//        marketNewsService.createMarketNews(marketNewsDTO);
//
//        List<EarningsDTO> earningsDTOS = restEarningsService.getEarnings("AAPL");
//        earningsService.createEarnings(earningsDTOS);
//
//        FinancialsDTO financialsDTOS = restFinancialsService.getFinancials();
//        financialsService.createFinancials(financialsDTOS);
//
//        SocialSentimentResponseDTO socialSentimentResponseDTO = restSocialSentimentService.getSocialSentiment("AAPL");
//        socialSentimentService.createSocialSentiment(socialSentimentResponseDTO);
//
//        List<FilingsDTO> filingsDTOS  = restFilingsService.getFilings();
//        filingsService.createFilings(filingsDTOS);
//
//        USPTOCompanyPatentsDTO usptoCompanyPatentsDTO = restUSPTOCompanyPatents.fetchUSPTOCompanyPatents();
//        usptoCompanyPatentsService.createUSPTOCompanyPatents(usptoCompanyPatentsDTO);
//
//    }
//