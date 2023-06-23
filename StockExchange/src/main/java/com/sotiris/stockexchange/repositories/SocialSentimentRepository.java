package com.sotiris.stockexchange.repositories;

import com.sotiris.stockexchange.model.SocialSentiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialSentimentRepository extends JpaRepository<SocialSentiment, Long> {
}
