package com.sotiris.stockexchange.dtos.finnhub.social_sentiment;

public record RedditDTO(
        String atTime,
        int mention,
        double positiveScore,
        double negativeScore,
        int positiveMention,
        int negativeMention,
        double score
) {
}
