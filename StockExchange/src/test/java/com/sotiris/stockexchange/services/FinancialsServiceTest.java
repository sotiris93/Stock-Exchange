package com.sotiris.stockexchange.services;

import com.sotiris.stockexchange.dtos.finnhub.financials.FinancialsDTO;
import com.sotiris.stockexchange.dtos.finnhub.financials.FinancialsDataDTO;
import com.sotiris.stockexchange.model.Financials;
import com.sotiris.stockexchange.model.FinancialsData;
import com.sotiris.stockexchange.repositories.FinancialsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FinancialsServiceTest {

    @Mock
    private FinancialsRepository financialsRepository;


    private FinancialsService financialsService;

    @Test
    void should_return_all_financials_data_from_db() {
        List<FinancialsDataDTO> financialsDataDTO = List.of(FinancialsDataDTO.builder().cik("abc").quarter(1).year(2020).build());
        List<FinancialsDTO> financialsDTOS = List.of(new FinancialsDTO("abc",financialsDataDTO, "AAPL" ));
        FinancialsData financialsData = FinancialsData.builder().cik("abc").quarter(1).year(2020).build();
        Financials financials = Financials.builder().cik("abc").financialsData(List.of(financialsData)).symbol("AAPL").build();
        financialsData.setFinancials(financials);

        when(financialsRepository.findAll()).thenReturn(List.of(financials));
        assertEquals(financialsDTOS, financialsService.getFinancials());
    }

}