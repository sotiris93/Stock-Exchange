package com.sotiris.stockexchange.controllers;

import com.sotiris.stockexchange.model.Filings;
import com.sotiris.stockexchange.repositories.FilingsRepository;
import com.sotiris.stockexchange.services.FilingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("filings")
public class FilingsController {
    private final FilingsService filingsService;
    private final FilingsRepository filingsRepository;

    @GetMapping
    public ResponseEntity<List<Filings>> getFilings() {
        return ResponseEntity.ok(filingsService.getAllFilings());
    }

    @GetMapping("/by-symbol")
    public ResponseEntity<List<Filings>> getFilingsBySymbol() {
        return ResponseEntity.ok(filingsRepository.showFilingsBySymbol());
        // excluding blank symbol values
    }

    @GetMapping("/XML-documents")
    public ResponseEntity<List<Filings>> getXMLDocuments() {
        return ResponseEntity.ok(filingsRepository.showAllXMLDocuments()); // ERROR
    }

    @GetMapping("/HTML-documents")
    public ResponseEntity<List<Filings>> getHTMLDocuments() {
        return ResponseEntity.ok(filingsRepository.showAllHTMLDocuments()); //ERROR
    }
}
