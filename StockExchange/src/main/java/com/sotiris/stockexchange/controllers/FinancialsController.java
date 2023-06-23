package com.sotiris.stockexchange.controllers;

import com.sotiris.stockexchange.dtos.finnhub.financials.FinancialsDTO;
import com.sotiris.stockexchange.dtos.finnhub.financials.FinancialsDataDTO;
import com.sotiris.stockexchange.rest_services.RestFinancialsService;
import com.sotiris.stockexchange.services.FinancialsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("financials")
public class FinancialsController {
    private final FinancialsService financialsService;
    private final RestFinancialsService restFinancialsService;

    @GetMapping
    public ResponseEntity<List<FinancialsDTO>> getFinancials() {
        return ResponseEntity.ok(financialsService.getFinancials());
    }
//    @GetMapping
//    public ResponseEntity<FinancialsAsReportedDTO> getFinancialsFromRestClient() {
//        return ResponseEntity.ok(restFinancials.getFinancials());
//    }
}
