package com.sotiris.stockexchange.repositories;

import com.sotiris.stockexchange.model.Twitter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TwitterRepository extends JpaRepository<Twitter, Long> {
}
