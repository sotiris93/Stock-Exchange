package com.sotiris.stockexchange.dtos.finnhub.recommendation_trends;

public record RecommendationTrendsDTO(
        int buy,
        int hold,
        String period,
        int sell,
        int stringBuy,
        int strongSell,
        String symbol
) {
}
