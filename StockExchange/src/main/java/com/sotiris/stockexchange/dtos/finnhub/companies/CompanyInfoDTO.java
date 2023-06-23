package com.sotiris.stockexchange.dtos.finnhub.companies;

public record CompanyInfoDTO(
        String country,
        String currency,
        String estimateCurrency,
        String exchange,
        String finnhubIndustry,
        String ipo,
        String logo,
        double marketCapitalization,  //total value of all a company's shares of stock
        String name,
        String phone,
        Long shareOutstanding,
        String ticker,
        String weburl
) {
}
