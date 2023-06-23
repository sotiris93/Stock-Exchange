package com.sotiris.stockexchange.services;

import com.sotiris.stockexchange.dtos.finnhub.stocks.StockSymbolDTO;
import com.sotiris.stockexchange.model.Stock;
import com.sotiris.stockexchange.repositories.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StockService {
    private final StockRepository stockRepository;

    public void createStock(StockSymbolDTO stockSymbolDTO) {
        stockRepository.save(new Stock(stockSymbolDTO.currency(), stockSymbolDTO.symbol(), stockSymbolDTO.description(), stockSymbolDTO.displaySymbol(),
                stockSymbolDTO.figi(), stockSymbolDTO.isin(), stockSymbolDTO.mic(), stockSymbolDTO.shareClassFIGI(), stockSymbolDTO.shareClassFIGI(),
                stockSymbolDTO.symbol2()));
    }

    public void createStocks(List<StockSymbolDTO> stockSymbolDTOS) {
//        List<Stock> stocks = new ArrayList<>();
//        for(StockSymbolDTO stockSymbolDTO : stockSymbolDTOS) {
//            stocks.add(new Stock(stockSymbolDTO.currency(), stockSymbolDTO.symbol()));
//        }

        List<Stock> stocks = stockSymbolDTOS.stream()
                .map(stockSymbolDTO -> new Stock(stockSymbolDTO.currency(), stockSymbolDTO.symbol(), stockSymbolDTO.description(), stockSymbolDTO.displaySymbol(),
                        stockSymbolDTO.figi(), stockSymbolDTO.isin(), stockSymbolDTO.mic(), stockSymbolDTO.shareClassFIGI(), stockSymbolDTO.shareClassFIGI(),
                        stockSymbolDTO.symbol2()))
                .toList();

        stockRepository.saveAll(stocks);
    }

    public List<Stock> getStocks() {
        List<Stock> stocks = stockRepository.findAll();
        if (stocks.isEmpty()) {
            throw new NoSuchElementException("Could not find the list of stocks");
        }
        return List.of(Stock.builder().currency("123").build());
    }
}
