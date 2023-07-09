package com.sotiris.stockexchange.services;

import com.sotiris.stockexchange.dtos.finnhub.companies.CompanyInfoDTO;
import com.sotiris.stockexchange.model.Company;
import com.sotiris.stockexchange.repositories.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CompanyServiceTest {
    @Mock
    private CompanyRepository companyRepository;

    @InjectMocks
    private CompanyService companyService;

    @Test
    void should_throw_NoSuchElementException_when_there_are_no_companies_in_the_db() {
        when(companyRepository.findAll()).thenReturn(Collections.emptyList());
        assertThrows(NoSuchElementException.class, () -> companyService.getAllCompaniesInfo());
    }

    @Test
    void should_return_all_company_infos_when_fetching_company_infos_from_db() {
        List<Company> expectedCompanies = List.of(Company.builder().name("TSLA").marketCapitalization(0.0).build(), Company.builder().name("AAPL").marketCapitalization(0.0).build(), Company.builder().name("COCA-COLA").marketCapitalization(0.0).build(),
                Company.builder().name("SSNLF").marketCapitalization(0.0).build(), Company.builder().name("ACN").marketCapitalization(0.0).build());

        List<Company> mockCompanies = List.of(Company.builder().name("AAPL").marketCapitalization(0.0).build(), Company.builder().name("TSLA").marketCapitalization(0.0).build(), Company.builder().name("COCA-COLA").marketCapitalization(0.0).build(),
                Company.builder().name("ACN").marketCapitalization(0.0).build(), Company.builder().name("SSNLF").marketCapitalization(0.0).build());

        when(companyRepository.findAll()).thenReturn(mockCompanies);
        List<Company> actualCompanies = companyService.getAllCompaniesInfo();
        assertEquals(expectedCompanies.size(), actualCompanies.size());
        assertTrue(expectedCompanies.containsAll(actualCompanies));
        assertTrue(actualCompanies.containsAll(expectedCompanies));
    }

    @Test
    void should_throw_IllegalArgumentException_when_provided_company_name_is_invalid() {
        assertThrows(IllegalArgumentException.class, () -> companyService.createCompany(CompanyInfoDTO.builder().name("").marketCapitalization(0).build()));
    }


    @Test
    void should_throw_NullPointerException_when_creating_CompanyInfoDTO_and_provided_companyInfoDTO_is_null() {
        assertThrows(NullPointerException.class, () -> companyService.createCompany(null));
    }

    @Test
    void should_return_true_when_company_count_is_greater_than_zero() {
        when(companyRepository.count()).thenReturn(1L);
        assertTrue(companyService.isCompanyCountGreaterThanZero());
        assertEquals(true, companyService.isCompanyCountGreaterThanZero());
    }

    @ParameterizedTest
    @CsvSource({"5,true", "0,false", "-5, false"})
    void should_return_correct_result(long count, boolean expectedResult) {
        when(companyRepository.count()).thenReturn(count);
        assertEquals(expectedResult, companyService.isCompanyCountGreaterThanZero());
    }
}