package com.immersion.riot.match.domain.repository;

import com.immersion.riot.match.app.dto.ChampionStatsDto;
import com.immersion.riot.match.domain.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    @Query("SELECT NEW com.immersion.riot.match.app.dto.ChampionStatsDto(p.championName, p.championId, COUNT(p), SUM(CASE WHEN p.win = true THEN 1 ELSE 0 END)," +
            " SUM(CASE WHEN p.win = false THEN 1 ELSE 0 END), AVG(p.kills), AVG(p.deaths), AVG(p.assists)) " +
            "FROM Participant p " +
            "WHERE p.puuid = :puuid " +
            "GROUP BY p.championName")
    List<ChampionStatsDto> getChampionStats(String puuid);

}
