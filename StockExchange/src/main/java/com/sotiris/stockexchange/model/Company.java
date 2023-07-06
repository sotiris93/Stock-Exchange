package com.sotiris.stockexchange.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="company")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Builder
@EqualsAndHashCode
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="country")
    String country;

    @Column(name="currency")
    String currency;

    @Column(name="estimatedCurrency")
    String estimatedCurrency;

    @Column(name="exchange")
    String exchange;

    @Column(name="finnhubIndustry")
    String finnhubIndustry;

    @Column(name="ipo")
    String ipo;

    @Column(name="logo")
    String logo;

    @Column(name="marketCapitalization")
    double marketCapitalization;  // total value of all a company's shares of stock

    @Column(name="name")
    String name;

    @Column(name="phone")
    String phone;

    @Column(name="shareOutstanding")
    Long shareOutstanding; //a company's stock currently held by all its shareholders

    @Column(name="ticker")
    String ticker;

    @Column(name="weburl")
    String weburl;


    public Company(String country, String currency, String estimatedCurrency, String exchange, String finnhubIndustry, String ipo, String logo,
                   double marketCapitalization, String name, String phone, Long shareOutstanding, String ticker, String weburl) {
        this.country = country;
        this.currency = currency;
        this.estimatedCurrency = estimatedCurrency;
        this.exchange = exchange;
        this.finnhubIndustry = finnhubIndustry;
        this.ipo = ipo;
        this.logo = logo;
        this.marketCapitalization = marketCapitalization;
        this.name = name;
        this.phone = phone;
        this.shareOutstanding = shareOutstanding;
        this.ticker = ticker;
        this.weburl = weburl;
    }
}
