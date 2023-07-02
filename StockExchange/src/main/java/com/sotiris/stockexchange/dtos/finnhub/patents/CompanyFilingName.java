package com.sotiris.stockexchange.dtos.finnhub.patents;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CompanyFilingName(@JsonProperty("NVIDIA CORPORATION") String name) {

}
