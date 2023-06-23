package com.sotiris.stockexchange.rest_services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestCompanyInfoWithEarnings {

    private final RestCompanyInfoService restCompanyInfoService;
    private final RestEarningsService restEarningsService;
}
