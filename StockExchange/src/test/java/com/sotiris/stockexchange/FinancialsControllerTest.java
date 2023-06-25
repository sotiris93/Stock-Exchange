package com.sotiris.stockexchange;

import com.sotiris.stockexchange.controllers.FinancialsController;
import com.sotiris.stockexchange.dtos.finnhub.financials.FinancialsDTO;
import com.sotiris.stockexchange.dtos.finnhub.financials.FinancialsDataDTO;
import com.sotiris.stockexchange.model.Financials;
import com.sotiris.stockexchange.rest_services.RestFinancialsService;
import com.sotiris.stockexchange.services.FinancialsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Collections;
import java.util.List;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(FinancialsController.class)
public class FinancialsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    FinancialsService financialsService;

    @MockBean
    RestFinancialsService restFinancialsService;

    @Test
    void should_return_all_financials() throws Exception {
        String cik_ = "320193";
        String companySymbol = "AAPL";

        String accessNumber = "0000320193-22-000108",
                symbol = "AAPL",
                cik  ="320193";
                int year = 2022,
                quarter = 0;
                String  form = "10-K",
                startDate  = "2021-09-26 00:00:00",
                endDate = "2022-09-24 00:00:00",
                filedDate = "2022-10-28 00:00:00",
                acceptedDate = "2022-10-27 18:01:14";

                FinancialsDataDTO financialsDataDTO = new FinancialsDataDTO(
                        accessNumber, symbol, cik, year, quarter, form, startDate,
                        endDate, filedDate, acceptedDate
                );
        List<FinancialsDataDTO> financialsDataDTOS = List.of(
                financialsDataDTO
        );
        FinancialsDTO financialsDTO = new FinancialsDTO(cik_, financialsDataDTOS, companySymbol);

        given(financialsService.getFinancials()).willReturn(Collections.singletonList(financialsDTO));

        mockMvc.perform(get("/financials")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized())
                .andReturn();


    }

}
