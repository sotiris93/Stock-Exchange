package com.sotiris.stockexchange.repositories;

import com.sotiris.stockexchange.model.USPTOCompanyPatents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface USPTOCompanyPatentsRepository extends JpaRepository<USPTOCompanyPatents, Long> {
}
