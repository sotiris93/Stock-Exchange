package com.sotiris.stockexchange.dtos.finnhub.patents;

import com.sotiris.stockexchange.dtos.finnhub.company_filing_name.CompanyFilingName;

import java.util.List;

public record PatentDTO(
        String applicationNumber,
        List<CompanyFilingName> companyFilingName,
        String description,
        String filingDate,
        String filingStatus,
        String patentStatus,
        String patentNUmber,
        String publicationDate,
        String type,
        String url
){
}
