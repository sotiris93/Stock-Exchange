package com.sotiris.stockexchange.repositories;

import com.sotiris.stockexchange.model.Financials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialsRepository extends JpaRepository<Financials, Long> {


}
