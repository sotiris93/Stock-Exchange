package com.sotiris.stockexchange.dtos.finnhub.usa_spending_activities;

public record USASpendingActivitiesDataDTO(
        String symbol,
        String recipientName,
        String RecipientParentName,
        String country,
        Long totalValue,
        String actionDate,
        String performanceStartDate,
        String performanceEndDate,
        String awardingAgencyName,
        String awardingSubAgencyName,
        String awardingOfficeName,
        String performanceCountry,
        String performanceCity,
        String performanceCounty,
        String performanceState,
        String performanceZipCode,
        String performanceCongressionalDistrict,
        String awardDescription,
        String naicsCode,
        String permalink
) {
}
