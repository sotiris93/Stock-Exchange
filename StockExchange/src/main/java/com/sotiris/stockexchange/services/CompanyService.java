package com.sotiris.stockexchange.services;

import com.sotiris.stockexchange.dtos.finnhub.companies.CompanyInfoDTO;
import com.sotiris.stockexchange.model.Company;
import com.sotiris.stockexchange.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public List<Company> getAllCompaniesInfo() {
        return companyRepository.findAll();
    }

    public void createCompany(CompanyInfoDTO companyInfoDTO) {
        companyRepository.save(new Company(companyInfoDTO.country(), companyInfoDTO.currency(), companyInfoDTO.estimateCurrency(),companyInfoDTO.exchange(), companyInfoDTO.finnhubIndustry(),
                companyInfoDTO.ipo(), companyInfoDTO.logo(), companyInfoDTO.marketCapitalization(), companyInfoDTO.name(), companyInfoDTO.phone(), companyInfoDTO.shareOutstanding(),
                companyInfoDTO.ticker(), companyInfoDTO.weburl()));
    }



}
