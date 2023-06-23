package com.sotiris.stockexchange.services;

import com.sotiris.stockexchange.dtos.finnhub.social_sentiment.RedditDTO;
import com.sotiris.stockexchange.dtos.finnhub.social_sentiment.SocialSentimentResponseDTO;
import com.sotiris.stockexchange.dtos.finnhub.social_sentiment.TwitterDTO;
import com.sotiris.stockexchange.model.Reddit;
import com.sotiris.stockexchange.model.SocialSentiment;
import com.sotiris.stockexchange.model.Twitter;
import com.sotiris.stockexchange.repositories.RedditRepository;
import com.sotiris.stockexchange.repositories.SocialSentimentRepository;
import com.sotiris.stockexchange.repositories.TwitterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SocialSentimentService {
    private final SocialSentimentRepository socialSentimentRepository;
    private final RedditRepository redditRepository;
    private final TwitterRepository twitterRepository;

    public Long createSocialSentiment(SocialSentimentResponseDTO socialSentimentResponseDTO) {
        List<Reddit> reddits = socialSentimentResponseDTO.reddits().stream()
                .map(redditDTO -> new Reddit(redditDTO.atTime(), redditDTO.mention(), redditDTO.positiveScore(), redditDTO.negativeScore(),
                        redditDTO.positiveMention(), redditDTO.negativeMention(), redditDTO.score()))
                .toList();
        List<Twitter> twitters = socialSentimentResponseDTO.twitters().stream()
                .map(twitterDTO -> new Twitter(twitterDTO.atTime(), twitterDTO.mention(), twitterDTO.positiveScore(), twitterDTO.negativeScore(),
                        twitterDTO.positiveMention(), twitterDTO.negativeMention(), twitterDTO.score()))
                .toList();
        redditRepository.saveAll(reddits);
        twitterRepository.saveAll(twitters);
        SocialSentiment socialSentiment = new SocialSentiment(reddits, socialSentimentResponseDTO.symbol(), twitters);
        return socialSentimentRepository.save(socialSentiment).getId();

    }

    public List<SocialSentimentResponseDTO> getSocialSentiments() {
        List<SocialSentimentResponseDTO> socialSentimentResponseDTOS = new ArrayList<>();
        List<SocialSentiment> socialSentiments = socialSentimentRepository.findAll();


        for (SocialSentiment socialSentiment : socialSentiments) {
            List<RedditDTO> redditDTOS = new ArrayList<>();
            List<TwitterDTO> twitterDTOS = new ArrayList<>();

            for (Reddit reddit : socialSentiment.getReddits()) {
                redditDTOS.add(new RedditDTO(reddit.getAtTime(), reddit.getMention(), reddit.getPositiveScore(), reddit.getNegativeScore(), reddit.getPositiveMention(), reddit.getNegativeMention(), reddit.getScore()));
            }

            for (Twitter twitter : socialSentiment.getTwitters()) {
                twitterDTOS.add(new TwitterDTO(twitter.getAtTime(), twitter.getMention(), twitter.getPositiveScore(), twitter.getNegativeScore(), twitter.getPositiveMention(), twitter.getNegativeMention(), twitter.getScore()));
            }
            socialSentimentResponseDTOS.add(new SocialSentimentResponseDTO(redditDTOS, socialSentiment.getSymbol(), twitterDTOS));
        }

        return socialSentimentResponseDTOS;
    }
}
