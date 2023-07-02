package com.sotiris.stockexchange.model;

import com.sotiris.stockexchange.dtos.finnhub.patents.PatentDataDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "USPTOCompanyPatents")
public class USPTOCompanyPatents {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @OneToMany(mappedBy = "usptoCompanyPatents", cascade = CascadeType.ALL)
    private List<PatentData> data;

    @Column(name="symbol")
    private String  symbol;

    public USPTOCompanyPatents(List<PatentData> data, String symbol) {
        this.data = data;
        this.symbol = symbol;
    }
}
