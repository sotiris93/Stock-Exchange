package com.sotiris.stockexchange.dtos.finnhub.social_sentiment;

public record TwitterDTO(
        String atTime,
        int mention,
        double positiveScore,
        double negativeScore,
        int positiveMention,
        int negativeMention,
        double score
) {
}
