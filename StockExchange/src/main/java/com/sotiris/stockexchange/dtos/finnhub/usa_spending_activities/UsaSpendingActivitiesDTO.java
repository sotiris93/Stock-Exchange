package com.sotiris.stockexchange.dtos.finnhub.usa_spending_activities;

import java.util.List;

public record UsaSpendingActivitiesDTO(List<USASpendingActivitiesDataDTO> data,String symbol) {
}
