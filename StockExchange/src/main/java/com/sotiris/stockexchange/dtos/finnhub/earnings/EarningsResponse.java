package com.sotiris.stockexchange.dtos.finnhub.earnings;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record EarningsResponse(@JsonProperty("earningsCalendar") List<EarningsDTO> earningsDTOS) {
}
