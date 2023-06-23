package com.sotiris.stockexchange.services;

import com.sotiris.stockexchange.dtos.finnhub.financials.FinancialsDTO;
import com.sotiris.stockexchange.dtos.finnhub.financials.FinancialsDataDTO;
import com.sotiris.stockexchange.model.Financials;
import com.sotiris.stockexchange.model.FinancialsData;
import com.sotiris.stockexchange.repositories.FinancialsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FinancialsService {

    private final FinancialsRepository financialsRepository;

    public void createFinancials(FinancialsDTO financialsDTO) {

        List<FinancialsData> financialsData = new ArrayList<>();
        Financials financials = new Financials(financialsDTO.cik(), financialsData, financialsDTO.symbol());

        for (FinancialsDataDTO financialsDataDTO : financialsDTO.data()) {
            financialsData.add(new FinancialsData(financials, financialsDataDTO.accessNumber(), financialsDataDTO.symbol(), financialsDataDTO.cik(), financialsDataDTO.year(), financialsDataDTO.quarter(),
                    financialsDataDTO.form(), financialsDataDTO.startDate(), financialsDataDTO.endDate(), financialsDataDTO.filedDate(), financialsDataDTO.acceptedDate()));
        }

        financialsRepository.save(financials);
    }

    public List<FinancialsDTO> getFinancials() {

        List<Financials> financials = financialsRepository.findAll();
        List<FinancialsDTO> financialsDTOS = new ArrayList<>();

        for (Financials financial : financials) {
            List<FinancialsDataDTO> financialsDataDTOS = new ArrayList<>();
            for (FinancialsData financialsData : financial.getFinancialsData()) {
                financialsDataDTOS.add(new FinancialsDataDTO(financialsData.getAccessNumber(), financialsData.getSymbol(), financialsData.getCik(), financialsData.getYear(), financialsData.getQuarter(), financialsData.getForm(),
                        financialsData.getStartDate(), financialsData.getEndDate(), financialsData.getFiledDate(), financialsData.getAcceptedDate()));
            }
            financialsDTOS.add(new FinancialsDTO(financial.getCik(), financialsDataDTOS, financial.getSymbol()));
        }
        return financialsDTOS;
    }

}
