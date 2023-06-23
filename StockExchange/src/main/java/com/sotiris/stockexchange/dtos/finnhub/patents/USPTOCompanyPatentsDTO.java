package com.sotiris.stockexchange.dtos.finnhub.patents;

import com.sotiris.stockexchange.dtos.finnhub.patents.PatentDTO;

import java.util.List;

public record USPTOCompanyPatentsDTO(List<PatentDTO> data, String symbol) {
}
