package com.sotiris.stockexchange.dtos.finnhub.countries_metadata;

public record CountriesMetadataDTO(
        String code2,
        String code3,
        String codeNo,
        String country,
        String currency,
        String currencyCode,
        String region,
        String subRegion
) {
}
