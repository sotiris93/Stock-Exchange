package com.sotiris.stockexchange;

import com.sotiris.stockexchange.model.Company;
import com.sotiris.stockexchange.repositories.CompanyRepository;
import com.sotiris.stockexchange.rest_services.RestEarningsService;
import com.sotiris.stockexchange.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Component
public class CompanyControllerTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyService companyService;

    @Test
    void should_return_all_companies_info() {  // getAllCompaniesInfo() service method
        //given
        Long id = 1L;
        String country = "US",
                currency = "USD",
                estimatedCurrency = "USD",
                exchange = "NASDAQ NMS - GLOBAL MARKET",
                finnhubIndustry = "Technology";
        String ipo = "1980-12-12",
                logo = "https://static2.finnhub.io/file/publicdatany/finnhubimage/stock_logo/AAPL.svg";
        double marketCapitalization = 2908551.572489;
        String name = "Apple Inc",
                phone = "14089961010.0";
        Long shareOutstanding = 15728L;
        String ticker = "AAPL",
                weburl = "https://www.apple.com/";

        Company company = new Company(id, country, currency, estimatedCurrency, exchange,
                finnhubIndustry, ipo, logo, marketCapitalization, name, phone, shareOutstanding,
                ticker, weburl);
        List<Company> expectedCompanies = List.of(company);

        //when
        List<Company> actualCompanies = companyRepository.findAll();

        //then
        assertEquals(expectedCompanies, actualCompanies);
    }




}
