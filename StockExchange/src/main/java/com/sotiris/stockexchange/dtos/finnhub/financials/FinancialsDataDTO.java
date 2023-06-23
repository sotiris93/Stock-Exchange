package com.sotiris.stockexchange.dtos.finnhub.financials;

public record FinancialsDataDTO(
        String accessNumber,
        String symbol,
        String cik,
        int year,
        int quarter,
        String form,
        String startDate,
        String endDate,
        String filedDate,
        String acceptedDate
        ) {
}
