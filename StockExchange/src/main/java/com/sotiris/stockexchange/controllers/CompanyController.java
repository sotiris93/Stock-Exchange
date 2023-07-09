package com.sotiris.stockexchange.controllers;

import com.sotiris.stockexchange.dtos.finnhub.companies.CompanyInfoDTO;
import com.sotiris.stockexchange.dtos.finnhub.company_with_earnings.CompanyInfoWithEarningsDTO;
import com.sotiris.stockexchange.model.Company;
import com.sotiris.stockexchange.repositories.CompanyRepository;
import com.sotiris.stockexchange.rest_services.RestCompanyInfoService;
import com.sotiris.stockexchange.rest_services.RestEarningsService;
import com.sotiris.stockexchange.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("companies")
public class CompanyController {
    private final RestCompanyInfoService restCompanyInfoService;
    private final CompanyService companyService;
    private final RestEarningsService restEarningsService;
    private final CompanyRepository companyRepository;


    @GetMapping
    public ResponseEntity<List<Company>> getCompanyInfo() {
        return ResponseEntity.ok(companyService.getAllCompaniesInfo());
    }

    @GetMapping("/earnings")
    public ResponseEntity<CompanyInfoDTO> getCompanyInfo(@RequestParam(required = false) String symbol) {
        return ResponseEntity.ok(restCompanyInfoService.getCompanyInfo(symbol));
    }

    @GetMapping("/companyInfoWithEarnings")
    public ResponseEntity<CompanyInfoWithEarningsDTO> getCompanyInfoWithEarnings(@RequestParam String symbol) {
        return ResponseEntity.ok(new CompanyInfoWithEarningsDTO(restCompanyInfoService.getCompanyInfo(symbol), restEarningsService.getEarnings(symbol)));
    }

    @GetMapping("/is-greater-than-zero")
    public ResponseEntity<Boolean> isGreaterThanZero() {
        return ResponseEntity.ok(companyService.isCompanyCountGreaterThanZero());
    }

}
