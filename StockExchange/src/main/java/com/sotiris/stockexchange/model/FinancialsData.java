package com.sotiris.stockexchange.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "financials_data")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FinancialsData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @ManyToOne
    @JoinColumn(name = "financials_id")
    private Financials financials;

    @Column(name = "accessNumber")
    private String accessNumber;

    @Column(name = "`symbol`")
    private String symbol;

    @Column(name = "cik")
    private String cik;

    @Column(name = "year")
    private int year;

    @Column(name = "quarter")
    private int quarter;

    @Column(name = "form")
    private String form;

    @Column(name = "startDate")
    private String startDate;

    @Column(name = "endDate")
    private String endDate;

    @Column(name = "filedDate")
    private String filedDate;

    @Column(name = "acceptedDate")
    private String acceptedDate;

    public FinancialsData(Financials financials, String accessNumber, String symbol, String cik, int year, int quarter, String form, String startDate, String endDate, String filedDate, String acceptedDate) {
        this.financials = financials;
        this.accessNumber = accessNumber;
        this.symbol = symbol;
        this.cik = cik;
        this.year = year;
        this.quarter = quarter;
        this.form = form;
        this.startDate = startDate;
        this.endDate = endDate;
        this.filedDate = filedDate;
        this.acceptedDate = acceptedDate;
    }
}
