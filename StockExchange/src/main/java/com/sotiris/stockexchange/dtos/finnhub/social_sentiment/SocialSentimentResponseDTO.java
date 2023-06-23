package com.sotiris.stockexchange.dtos.finnhub.social_sentiment;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record SocialSentimentResponseDTO(@JsonProperty("reddit") List<RedditDTO> reddits, String symbol, @JsonProperty("twitter") List<TwitterDTO> twitters) {
}
