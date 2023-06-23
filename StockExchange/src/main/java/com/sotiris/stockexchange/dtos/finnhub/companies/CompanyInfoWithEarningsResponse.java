package com.sotiris.stockexchange.dtos.finnhub.companies;

import com.sotiris.stockexchange.dtos.finnhub.earnings.EarningsDTO;

import java.util.List;

public record CompanyInfoWithEarningsResponse(CompanyInfoDTO companyInfoDTO, List<EarningsDTO> earningsDTOS) {
}
