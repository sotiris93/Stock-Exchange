package com.sotiris.stockexchange.repositories;

import com.sotiris.stockexchange.model.Earnings;
import com.sotiris.stockexchange.model.MarketNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EarningsRepository extends JpaRepository<Earnings, Long> {

    @Query(value = "SELECT * FROM market_news WHERE source = 'CNBC'" , nativeQuery = true)
    List<MarketNews> findCNBCNews();

}
