package com.sotiris.stockexchange.services;

import com.sotiris.stockexchange.dtos.finnhub.companies.CompanyInfoDTO;
import com.sotiris.stockexchange.model.Company;
import com.sotiris.stockexchange.repositories.CompanyRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public List<Company> getAllCompaniesInfo() {
        List<Company> companies = companyRepository.findAll();
        if(companies.isEmpty()) {
            throw new NoSuchElementException();
        }
        return companies;
    }

    public void createCompany(@NonNull CompanyInfoDTO companyInfoDTO) {
        if(companyInfoDTO.name() == null || companyInfoDTO.name().isEmpty()) {
            throw new IllegalArgumentException();
        }
        companyRepository.save(new Company(companyInfoDTO.country(), companyInfoDTO.currency(), companyInfoDTO.estimateCurrency(),companyInfoDTO.exchange(), companyInfoDTO.finnhubIndustry(),
                companyInfoDTO.ipo(), companyInfoDTO.logo(), companyInfoDTO.marketCapitalization(), companyInfoDTO.name(), companyInfoDTO.phone(), companyInfoDTO.shareOutstanding(),
                companyInfoDTO.ticker(), companyInfoDTO.weburl()));
    }

    public boolean isCompanyCountGreaterThanZero() {
        return companyRepository.count() > 0;
    }
}
