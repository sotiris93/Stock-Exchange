package com.sotiris.stockexchange.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "financials")
@Getter
public class Financials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cik")
    private String cik;

    @OneToMany(mappedBy = "financials", cascade = CascadeType.ALL)
    private List<FinancialsData> financialsData;

    @Column(name = "`symbol`")
    private String symbol;

    public Financials(String cik, List<FinancialsData> financialsData, String symbol) {
        this.cik = cik;
        this.financialsData = financialsData;
        this.symbol = symbol;
    }
}
