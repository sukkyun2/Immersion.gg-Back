package com.immersion.riot.match.domain.repository;

import com.immersion.riot.match.domain.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, String> {
}
