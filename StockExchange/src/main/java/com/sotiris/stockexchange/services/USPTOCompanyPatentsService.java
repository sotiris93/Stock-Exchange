package com.sotiris.stockexchange.services;

import com.sotiris.stockexchange.dtos.finnhub.patents.PatentDataDTO;
import com.sotiris.stockexchange.dtos.finnhub.patents.USPTOCompanyPatentsDTO;
import com.sotiris.stockexchange.model.PatentData;
import com.sotiris.stockexchange.model.USPTOCompanyPatents;
import com.sotiris.stockexchange.repositories.USPTOCompanyPatentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class USPTOCompanyPatentsService {

private final USPTOCompanyPatentsRepository usptoCompanyPatentsRepository;

public void createUSPTOCompanyPatents(USPTOCompanyPatentsDTO usptoCompanyPatentsDTO) {
    List<PatentData> patentData = new ArrayList<>();
    USPTOCompanyPatents usptoCompanyPatents = new USPTOCompanyPatents(patentData, usptoCompanyPatentsDTO.symbol());

    for(PatentDataDTO patentDataDTO : usptoCompanyPatentsDTO.data()) {
        patentData.add(new PatentData( patentDataDTO.applicationNumber(), patentDataDTO.description(),
                patentDataDTO.filingDate(), patentDataDTO.filingStatus(),  patentDataDTO.patentNumber(),
                patentDataDTO.publicationDate(), patentDataDTO.type(),
                patentDataDTO.url()));
    }

    usptoCompanyPatentsRepository.save(usptoCompanyPatents);
}

public List<USPTOCompanyPatentsDTO> getUSPTOCompanyPatents() {
    List<USPTOCompanyPatentsDTO> usptoCompanyPatentsDTO = new ArrayList<>();
    List<USPTOCompanyPatents> usptoCompanyPatents = usptoCompanyPatentsRepository.findAll();
    List<PatentDataDTO> patentDataDTOS = new ArrayList<>();

    for(USPTOCompanyPatents usptoCompanyPatent : usptoCompanyPatents) {
        for (PatentData patentData: usptoCompanyPatent.getData()) {
            patentDataDTOS.add(new PatentDataDTO(patentData.getApplicationNumber(), patentData.getDescription(),
                    patentData.getFilingDate(), patentData.getFilingStatus(), patentData.getPatentNumber(),
                    patentData.getPublicationDate(), patentData.getType(), patentData.getUrl()));
        }
        usptoCompanyPatentsDTO.add(new USPTOCompanyPatentsDTO(patentDataDTOS, usptoCompanyPatent.getSymbol()));
    }
    return usptoCompanyPatentsDTO;
}
}
