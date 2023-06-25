package com.sotiris.stockexchange.rest_services;

import com.sotiris.stockexchange.clients.RestTemplateClient;
import com.sotiris.stockexchange.dtos.finnhub.social_sentiment.SocialSentimentResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RestSocialSentimentService {
    private final RestTemplateClient restTemplateClient;

    public SocialSentimentResponseDTO getSocialSentiment(String symbol) {
        return restTemplateClient.fetchSocialSentiment(symbol);
    }
}
