package com.sotiris.stockexchange.dtos.finnhub.financials;

import java.util.List;

public record FinancialsAsReportedDTO(String cik, List<FinancialsDTO> data, String symbol) {
}
