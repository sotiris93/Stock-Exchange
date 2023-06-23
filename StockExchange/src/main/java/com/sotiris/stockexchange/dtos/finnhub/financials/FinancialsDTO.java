package com.sotiris.stockexchange.dtos.finnhub.financials;

import java.util.List;

public record FinancialsDTO(String cik, List<FinancialsDataDTO> data, String symbol) {
}
