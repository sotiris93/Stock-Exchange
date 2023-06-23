package com.sotiris.stockexchange.dtos.finnhub.stocks;

public record StockSymbolDTO(
        String currency,
        String description,
        String displaySymbol,
        String figi,
        String isin,
        String mic,
        String shareClassFIGI,
        String symbol,
        String symbol2,
        String type
) {
}
