package com.sotiris.stockexchange.repositories;

import com.sotiris.stockexchange.model.Company;
import com.sotiris.stockexchange.model.MarketNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketNewsRepository extends JpaRepository<MarketNews, Long> {

    @Query(value = "SELECT * FROM market_news WHERE category = 'top news'" , nativeQuery = true)
    List<MarketNews> findOnlyTheTopNews();

    @Query(value = "SELECT * FROM market_news WHERE category = 'top news' ORDER BY datetime desc limit 10" , nativeQuery = true)
    List<MarketNews> findLatestTop10News();

    @Query(value = "SELECT * FROM market_news WHERE source = 'MarketWatch'" , nativeQuery = true)
    List<MarketNews> findMarketWatchNews();

    @Query(value = "SELECT * FROM market_news WHERE source = 'CNBC'" , nativeQuery = true)
    List<MarketNews> findCNBCNews();
}
