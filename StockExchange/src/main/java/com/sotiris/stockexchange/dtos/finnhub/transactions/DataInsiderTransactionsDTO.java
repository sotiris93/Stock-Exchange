package com.sotiris.stockexchange.dtos.finnhub.transactions;

public record DataInsiderTransactionsDTO(
        String name,
        Long share,
        Long change,
        String filingDate,
        String transactionDate,
        String transactionCode,
        Long transactionPrice) {
}
