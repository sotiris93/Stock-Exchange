package com.sotiris.stockexchange.services;

import com.sotiris.stockexchange.dtos.finnhub.earnings.EarningsDTO;
import com.sotiris.stockexchange.model.Earnings;
import com.sotiris.stockexchange.repositories.EarningsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EarningsService {
    private final EarningsRepository earningsRepository;

    public void createEarnings(List<EarningsDTO> earningsDTOS) {
        List<Earnings> earnings = new ArrayList<>();

        for (EarningsDTO earningsDTO : earningsDTOS) {
            earnings.add(new Earnings(
                    earningsDTO.date(),
                    earningsDTO.epsActual(),
                    earningsDTO.epsEstimate(),
                    earningsDTO.hour(),
                    earningsDTO.quarter(),
                    earningsDTO.revenueActual(),
                    earningsDTO.revenueEstimate(),
                    earningsDTO.symbol(),
                    earningsDTO.year()
            ));
        }

        earningsRepository.saveAll(earnings);
    }

    public List<EarningsDTO> getEarnings() {
        List<Earnings> earningsFromDatabase = earningsRepository.findAll();
        List<EarningsDTO> earningsDTOS = new ArrayList<>();

        for (Earnings earnings : earningsFromDatabase) {
            EarningsDTO convertedEarningsDTO = new EarningsDTO(
                    earnings.getDate(), earnings.getEpsActual(),
                    earnings.getEpsEstimate(), earnings.getHour(), earnings.getQuarter(), earnings.getRevenue(), earnings.getRevenueEstimate(),
                    earnings.getSymbol(), earnings.getYear());
            earningsDTOS.add(convertedEarningsDTO);

//            new EarningsDTO(earnings.getDate(), earnings.getEpsActual(), earnings.getEpsEstimate(), earnings.getSymbol(), earnings.getQuarter(), earnings.getRevenue(), earnings.getRevenueEstimate(), earnings.getHour()

        }
        return earningsDTOS;
    }
}
