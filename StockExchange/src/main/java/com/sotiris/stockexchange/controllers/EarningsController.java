package com.sotiris.stockexchange.controllers;

import com.sotiris.stockexchange.dtos.finnhub.earnings.EarningsDTO;
import com.sotiris.stockexchange.model.Earnings;
import com.sotiris.stockexchange.repositories.EarningsRepository;
import com.sotiris.stockexchange.services.EarningsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/earnings")
public class EarningsController {
    private final EarningsService earningsService;
    private final EarningsRepository earningsRepository;

    @GetMapping
    public ResponseEntity<List<EarningsDTO>> getEarnings() {
        return ResponseEntity.ok(earningsService.getEarnings());
    }



}
