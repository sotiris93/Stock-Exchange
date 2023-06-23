package com.sotiris.stockexchange.repositories;

import com.sotiris.stockexchange.model.MarketNews;
import com.sotiris.stockexchange.model.Reddit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RedditRepository extends JpaRepository<Reddit, Long> {

}
