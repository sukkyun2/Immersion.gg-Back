package com.immersion.riot.match.domain.repository;

import com.immersion.riot.match.domain.entity.Match;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MatchRepository extends JpaRepository<Match, String> {

    @Query("SELECT m FROM Match m JOIN m.participants p WHERE p.puuid = :puuid")
    Page<Match> getMatchListByPuuid(String puuid, Pageable pageable);
}
