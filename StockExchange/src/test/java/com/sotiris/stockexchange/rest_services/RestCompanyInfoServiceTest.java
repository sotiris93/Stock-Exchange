package com.sotiris.stockexchange.rest_services;

import com.sotiris.stockexchange.clients.RestTemplateClient;
import com.sotiris.stockexchange.dtos.finnhub.companies.CompanyInfoDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RestCompanyInfoServiceTest {
    @Mock
    private RestTemplateClient restTemplateClient;

    @InjectMocks
    private RestCompanyInfoService restCompanyInfoService;

    @Test
    void should_throw_exception_when_provided_symbol_is_null() {
        assertThrows(IllegalArgumentException.class, () -> restCompanyInfoService.getCompanyInfo(null));
    }

    @Test
    void should_throw_exception_when_provided_symbol_is_blank() {
        assertThrows(IllegalArgumentException.class, () -> restCompanyInfoService.getCompanyInfo(" "));
    }

    @Test
    void should_return_company_info_when_provided_symbol_is_valid() {
        CompanyInfoDTO companyInfoDTO = new CompanyInfoDTO("Greece", null, null, null, null,
                null, null, 0.0, null, null, null, null, null);

        CompanyInfoDTO companyInfoDTO1 = new CompanyInfoDTO("Greece", null, null, null, null,
                null, null, 0.0, null, null, null, null, null);

        when(restTemplateClient.fetchCompanyProfileInfo(anyString())).thenReturn(companyInfoDTO1);
        assertEquals(companyInfoDTO, restCompanyInfoService.getCompanyInfo("AAPL"));
    }

    @Test
    void should_throw_the_same_exception_when_rest_template_client_throws_an_exception() {
        when(restTemplateClient.fetchCompanyProfileInfo(anyString())).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, () -> restCompanyInfoService.getCompanyInfo("AAPL"));
    }

}