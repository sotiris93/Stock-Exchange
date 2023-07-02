package com.sotiris.stockexchange.services;

import com.sotiris.stockexchange.dtos.finnhub.filings.FilingsDTO;
import com.sotiris.stockexchange.model.Filings;
import com.sotiris.stockexchange.repositories.FilingsRepository;
import com.sotiris.stockexchange.rest_services.RestFilingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilingsService {


    private final FilingsRepository filingsRepository;

    public List<Filings> createFilings(List<FilingsDTO> filingsDTOS) {
        List<Filings> filings = new ArrayList<>();

        for(FilingsDTO filingsDTO : filingsDTOS) {
            filings.add(new Filings(filingsDTO.accessNumber(), filingsDTO.symbol(), filingsDTO.cik(),
                    filingsDTO.form(), filingsDTO.filedDate(), filingsDTO.acceptedDate(),
                    filingsDTO.reportUrl(), filingsDTO.filingUrl()));
        }

        filingsRepository.saveAll(filings);
        return filings;

    }

    public List<Filings> getAllFilings() {
        return filingsRepository.findAll();
    }
}
