package com.sotiris.stockexchange.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reddit")
@Getter
public class Reddit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "atTime")
    private String atTime;

    @Column(name = "mention")
    private int mention;

    @Column(name = "positiveScore")
    private double positiveScore;

    @Column(name = "negativeScore")
    private double negativeScore;

    @Column(name = "positiveMention")
    private int positiveMention;

    @Column(name = "negativeMention")
    private int negativeMention;

    @Column(name = "score")
    private double score;

    @ManyToOne
    @JoinColumn(name="social_sentiment_id")
    private SocialSentiment socialSentiment;

    public Reddit(String atTime, int mention, double positiveScore, double negativeScore, int positiveMention, int negativeMention, double score) {
        this.atTime = atTime;
        this.mention = mention;
        this.positiveScore = positiveScore;
        this.negativeScore = negativeScore;
        this.positiveMention = positiveMention;
        this.negativeMention = negativeMention;
        this.score = score;
    }
}
