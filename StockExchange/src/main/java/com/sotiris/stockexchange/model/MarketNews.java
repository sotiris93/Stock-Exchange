package com.sotiris.stockexchange.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="market_news")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MarketNews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name= "`category`")
    private String category;

    @Column(name="datetime")
    private Long datetime;

    @Column(name="headline")
    private String headline;

    @Column(name="image")
    private String image;

    @Column(name="related")
    private String related;

    @Column(name="source")
    private String source;

    @Column(name="summary", length = 300)
    private String summary;

    @Column(name="url")
    private String url;

    public MarketNews(String category, Long datetime, String headline, String image, String related, String source, String summary, String url) {
        this.category = category;
        this.datetime = datetime;
        this.headline = headline;
        this.image = image;
        this.related = related;
        this.source = source;
        this.summary = summary;
        this.url = url;
    }
}
