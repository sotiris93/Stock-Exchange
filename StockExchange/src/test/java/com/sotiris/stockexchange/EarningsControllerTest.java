package com.sotiris.stockexchange;

import com.sotiris.stockexchange.controllers.EarningsController;
import com.sotiris.stockexchange.dtos.finnhub.earnings.EarningsDTO;
import com.sotiris.stockexchange.services.EarningsService;
import com.sotiris.stockexchange.services.MyUserDetailsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WebMvcTest(EarningsController.class)
public class EarningsControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ApplicationContext context;

    @MockBean
    private EarningsService earningsService;


    @Test
    void should_return_all_earnings() throws Exception {
        String date = "2023-05-04";
        double epsActual = 1.52;
        double epsEstimate = 1.4623;
        String hour = "amc";
        int quarter = 2;
        Long revenueActual = 94836000000L;
        Long revenueEstimate = 94354557913L;
        String symbol = "AAPL";
        int year = 2023;

        EarningsDTO earningsDTO = new EarningsDTO(date, epsActual, epsEstimate, hour, quarter, revenueActual, revenueEstimate, symbol, year);

        List<EarningsDTO> earningsDTOS = List.of(earningsDTO);
        given(earningsService.getEarnings()).willReturn(earningsDTOS);
        MyUserDetailsService myUserDetailsService = context.getBean(MyUserDetailsService.class);
        mockMvc.perform(get("/earnings")
                        .param("username", "user")
                        .param("password", "123")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }
}
