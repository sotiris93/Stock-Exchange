package com.sotiris.stockexchange.dtos.finnhub.patents;

import java.util.List;

public record USPTOCompanyPatentsDTO(List<PatentDataDTO> data, String symbol) {

}
