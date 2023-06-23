package com.sotiris.stockexchange.dtos.finnhub.transactions;

import com.sotiris.stockexchange.dtos.finnhub.transactions.DataInsiderTransactionsDTO;

import java.util.List;

public record InsiderTransactionsDTO(List<DataInsiderTransactionsDTO> data) {
}
