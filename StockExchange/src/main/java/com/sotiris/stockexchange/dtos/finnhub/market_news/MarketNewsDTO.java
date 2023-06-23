package com.sotiris.stockexchange.dtos.finnhub.market_news;

public record MarketNewsDTO(
        String category,
        Long datetime,
        String headline,
        String image,
        String related,
        String source,
        String summary,
        String url
) {
}
