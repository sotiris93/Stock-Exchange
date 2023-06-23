package com.sotiris.stockexchange.dtos.finnhub.company_with_earnings;

import com.sotiris.stockexchange.dtos.finnhub.companies.CompanyInfoDTO;
import com.sotiris.stockexchange.dtos.finnhub.earnings.EarningsDTO;

import java.util.List;

public record CompanyInfoWithEarningsDTO(CompanyInfoDTO companyInfoDTO, List<EarningsDTO> earningsDTOS) {
}
