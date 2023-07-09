package com.sotiris.stockexchange;

import com.sotiris.stockexchange.rest_services.RestCompanyInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class StockExchangeApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private RestCompanyInfoService restCompanyInfoService;

    @Test
    void test() {
        System.out.println(restCompanyInfoService.getCompanyInfo("AAPL"));
    }
}
