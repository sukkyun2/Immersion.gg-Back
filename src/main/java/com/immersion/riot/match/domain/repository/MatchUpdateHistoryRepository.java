package com.immersion.riot.match.domain.repository;


import com.immersion.riot.match.domain.entity.MatchUpdateHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchUpdateHistoryRepository extends JpaRepository<MatchUpdateHistory, String> {
}
