package com.sotiris.stockexchange.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Table(name= "filings")
public class Filings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="accessNumber")
    private String accessNumber;

    @Column(name="symbol")
    private String symbol;

    @Column(name="cik")
    private String cik;

    @Column(name="form")
    private String  form;

    @Column(name="filedDate")
    private String filedDate;

    @Column(name="acceptedDate")
    private String acceptedDate;

    @Column(name="reportUrl")
    private String reportUrl;

    @Column(name="filingUrl")
    private String filingUrl;

    public Filings(String accessNumber, String symbol, String cik, String form,
                   String filedDate, String acceptedDate, String reportUrl, String filingUrl) {
        this.accessNumber = accessNumber;
        this.symbol = symbol;
        this.cik = cik;
        this.form = form;
        this.filedDate = filedDate;
        this.acceptedDate = acceptedDate;
        this.reportUrl = reportUrl;
        this.filingUrl = filingUrl;
    }
}
