package com.sotiris.stockexchange.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "earnings")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Earnings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private String date;

    @Column(name = "epsActual")
    private double epsActual;

    @Column(name = "epsEstimate")
    private double epsEstimate;

    @Column(name = "hour")
    private String hour;

    @Column(name = "quarter")
    private int quarter;

    @Column(name = "revenue")
    private Long revenue;

    @Column(name = "revenueEstimate")
    private Long revenueEstimate;

    @Column(name = "`symbol`")
    private String symbol;

    @Column(name = "year;")
    private int year;



    public Earnings(String date, double epsActual, double epsEstimate, String hour, int quarter, Long revenue, Long revenueEstimate, String symbol, int year) {
        this.date = date;
        this.epsActual = epsActual;
        this.epsEstimate = epsEstimate;
        this.hour = hour;
        this.quarter = quarter;
        this.revenue = revenue;
        this.revenueEstimate = revenueEstimate;
        this.symbol = symbol;
        this.year = year;
    }
}
