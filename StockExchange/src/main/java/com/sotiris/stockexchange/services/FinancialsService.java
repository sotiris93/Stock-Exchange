package com.sotiris.stockexchange.services;

import com.sotiris.stockexchange.dtos.finnhub.financials.FinancialsAsReportedDTO;
import com.sotiris.stockexchange.dtos.finnhub.financials.FinancialsDTO;
import com.sotiris.stockexchange.model.Financials;
import com.sotiris.stockexchange.model.FinancialsData;
import com.sotiris.stockexchange.repositories.FinancialsDataRepository;
import com.sotiris.stockexchange.repositories.FinancialsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FinancialsService {

    private final FinancialsRepository financialsRepository;
//    private final FinancialsDataRepository financialsDataRepository;


    public void createFinancials(FinancialsAsReportedDTO financialsAsReportedDTO) {

        List<FinancialsData> financialsData = new ArrayList<>();
        for(FinancialsDTO  financialsDTO :  financialsAsReportedDTO.data()) {
            financialsData.add(new FinancialsData(financialsDTO.accessNumber(), financialsDTO.symbol(), financialsDTO.cik(), financialsDTO.year(), financialsDTO.quarter(),
                    financialsDTO.form(), financialsDTO.startDate(), financialsDTO.endDate(), financialsDTO.filedDate(), financialsDTO.acceptedDate()));
        }
        Financials financials = new Financials(financialsAsReportedDTO.cik(), financialsData, financialsAsReportedDTO.symbol());
//        financialsDataRepository.saveAll(financialsData);
        financialsRepository.save(financials);
    }

    public List<Financials> getFinancials() {
        return financialsRepository.findAll();
    }

}
