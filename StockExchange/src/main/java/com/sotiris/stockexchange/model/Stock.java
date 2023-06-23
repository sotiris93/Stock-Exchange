package com.sotiris.stockexchange.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name = "stocks")
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Stock {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "currency")
    private String currency;

    @Column(name="description")
    private  String description;

    @Column(name="displaySymbol")
    private String displaySymbol;

    @Column(name="figi")
    private String figi;

    @Column(name="isin")
    private String isin;

    @Column(name="mic")
    private String mic;

    @Column(name="shareClassFIGI")
    private String shareClassFIGI;

    @Column(name = "symbol")
    private String symbol;

    @Column(name="symbol2")
    private String symbol2;

    @Column(name="`type`")
    private String type;


    @Builder
    public Stock(String currency, String description, String displaySymbol, String figi, String isin, String mic, String shareClassFIGI, String symbol, String symbol2, String type) {
        this.currency = currency;
        this.description = description;
        this.displaySymbol = displaySymbol;
        this.figi = figi;
        this.isin = isin;
        this.mic = mic;
        this.shareClassFIGI = shareClassFIGI;
        this.symbol = symbol;
        this.symbol2 = symbol2;
        this.type = type;
    }

    public Stock(String currency, String description) {
        this.currency = currency;
        this.description = description;
    }


}
