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
    private List<Reddit> reddits;

    @Column(name = "`symbol`")
    private String symbol;

    @OneToMany(mappedBy = "socialSentiment")
    private List<Twitter> twitters;

    public SocialSentiment(List<Reddit> reddits, String symbol, List<Twitter> twitters) {
        this.reddits = reddits;
        this.symbol = symbol;
        this.twitters = twitters;
    }
}
