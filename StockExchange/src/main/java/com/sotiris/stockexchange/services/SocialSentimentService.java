package com.sotiris.stockexchange.services;

import com.sotiris.stockexchange.dtos.finnhub.social_sentiment.SocialSentimentResponseDTO;
import com.sotiris.stockexchange.model.Reddit;
import com.sotiris.stockexchange.model.SocialSentiment;
import com.sotiris.stockexchange.model.Twitter;
import com.sotiris.stockexchange.repositories.RedditRepository;
import com.sotiris.stockexchange.repositories.SocialSentimentRepository;
import com.sotiris.stockexchange.repositories.TwitterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SocialSentimentService {
    private final SocialSentimentRepository socialSentimentRepository;
    private final RedditRepository redditRepository;
    private final TwitterRepository twitterRepository;

    public Long createSocialSentiment(SocialSentimentResponseDTO socialSentimentResponseDTO) {
        List<Reddit> reddits = socialSentimentResponseDTO.reddit().stream()
                .map(redditDTO -> new Reddit(redditDTO.atTime(), redditDTO.mention(), redditDTO.positiveScore(), redditDTO.negativeScore(),
                        redditDTO.positiveMention(), redditDTO.negativeMention(), redditDTO.score()))
                .toList();
        List<Twitter> twitters = socialSentimentResponseDTO.twitter().stream()
                .map(twitterDTO -> new Twitter(twitterDTO.atTime(), twitterDTO.mention(), twitterDTO.positiveScore(), twitterDTO.negativeScore(),
                        twitterDTO.positiveMention(), twitterDTO.negativeMention(), twitterDTO.score()))
                .toList();
        redditRepository.saveAll(reddits);
        twitterRepository.saveAll(twitters);
        SocialSentiment socialSentiment = new SocialSentiment(reddits, socialSentimentResponseDTO.symbol(), twitters);
        return socialSentimentRepository.save(socialSentiment).getId();

    }

    public List<SocialSentiment> getSocialSentiments() {
        return socialSentimentRepository.findAll();
    }
}
