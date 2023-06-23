package com.sotiris.stockexchange.repositories;

import com.sotiris.stockexchange.model.FinancialsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialsDataRepository extends JpaRepository<FinancialsData, Long> {
}
