package com.sotiris.stockexchange.dtos.finnhub.filings;

public record FilingsDTO(
        String accessNumber,
        String symbol,
        String cik,
        String form,
        String filedDate,
        String acceptedDate,
        String reportUrl,
        String filingUrl
) {
}
