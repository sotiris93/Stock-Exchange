package com.sotiris.stockexchange.dtos.finnhub.social_sentiment;

import java.util.List;

public record SocialSentimentResponseDTO(List<RedditDTO> reddit, String symbol, List<TwitterDTO> twitter) {
}
