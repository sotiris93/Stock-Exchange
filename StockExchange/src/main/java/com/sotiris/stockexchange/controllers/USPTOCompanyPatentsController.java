package com.sotiris.stockexchange.controllers;

import com.sotiris.stockexchange.dtos.finnhub.patents.USPTOCompanyPatentsDTO;
import com.sotiris.stockexchange.model.USPTOCompanyPatents;
import com.sotiris.stockexchange.services.USPTOCompanyPatentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("uspto-patents")
public class USPTOCompanyPatentsController {
    private final USPTOCompanyPatentsService usptoCompanyPatentsService;

    @GetMapping
    public ResponseEntity<List<USPTOCompanyPatentsDTO>> getUSPTOCompanyPatents() {
        return ResponseEntity.ok(usptoCompanyPatentsService.getUSPTOCompanyPatents());
    }
}
