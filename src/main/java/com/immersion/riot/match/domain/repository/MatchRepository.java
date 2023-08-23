package com.immersion.riot.match.domain.repository;

import com.immersion.riot.match.domain.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface MatchRepository extends JpaRepository<Match, String> {

    @Query("SELECT m FROM Match m JOIN m.participants p WHERE p.puuid = :puuid")
    List<Match> getMatchListByPuuid(String puuid);
}
