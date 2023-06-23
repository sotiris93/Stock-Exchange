package com.sotiris.stockexchange.dtos.finnhub.earnings;

import lombok.Builder;

@Builder
public record EarningsDTO(
        String date,
        double epsActual,
        double epsEstimate,
        String hour,
        int quarter,
        Long revenueActual,
        Long revenueEstimate,
        String symbol,
        int year
) {
}
