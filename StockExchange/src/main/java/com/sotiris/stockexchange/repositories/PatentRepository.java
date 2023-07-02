package com.sotiris.stockexchange.repositories;

import com.sotiris.stockexchange.model.PatentData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface PatentRepository extends JpaRepository<PatentData, Long> {
}
