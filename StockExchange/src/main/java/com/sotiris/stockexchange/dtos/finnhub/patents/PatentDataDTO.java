package com.sotiris.stockexchange.dtos.finnhub.patents;

public record PatentDataDTO(
        String applicationNumber,
       // List<CompanyFilingName> companyFilingName,
        String description,
        String filingDate,
        String filingStatus,
        String patentNumber,
        String publicationDate,
        String type,
        String url
){
}
