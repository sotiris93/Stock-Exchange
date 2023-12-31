package com.sotiris.stockexchange.repositories;

import com.sotiris.stockexchange.model.Filings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilingsRepository extends JpaRepository<Filings, Long> {

    @Query(value = "SELECT * FROM filings WHERE symbol <> '' ORDER BY symbol", nativeQuery = true)
    List<Filings> showFilingsBySymbol(); //excluding blank symbol values

    @Query(value = "SELECT report_url FROM filings", nativeQuery = true)
    List<String> showAllXMLDocuments();

    @Query(value = "SELECT * FROM filings WHERE report_url like '%.html' OR report_url " +
            "LIKE '%.htm'", nativeQuery = true)
    List<Filings> showAllHTMLDocuments();

    @Query(value = "SELECT f from Filings f")
    List<Filings> findAllUsingJPQL();
}


