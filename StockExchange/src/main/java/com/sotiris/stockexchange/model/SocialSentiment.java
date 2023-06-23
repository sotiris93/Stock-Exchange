package com.sotiris.stockexchange.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "social_sentiment")
@Getter
public class SocialSentiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @OneToMany(mappedBy = "socialSentiment")
    private List<Reddit> reddit;

    @Column(name = "`symbol`")
    private String symbol;

    @OneToMany(mappedBy = "socialSentiment")
    private List<Twitter> twitter;

    public SocialSentiment(List<Reddit> reddit, String symbol, List<Twitter> twitter) {
        this.reddit = reddit;
        this.symbol = symbol;
        this.twitter = twitter;
    }
}
