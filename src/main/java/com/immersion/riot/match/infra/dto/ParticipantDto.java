package com.immersion.riot.match.infra.dto;

import com.immersion.riot.match.app.dto.MatchDto;
import com.immersion.riot.match.domain.entity.Participant;

public record ParticipantDto(
        int assists,
        int champLevel,
        int championId,
        String championName,
        int deaths,
        int item0,
        int item1,
        int item2,
        int item3,
        int item4,
        int item5,
        int item6,
        int kills,
        int participantId,
        int totalMinionsKilled,
        String puuid,
        String summonerId,
        int summoner1Id,
        int summoner2Id,
        PerksDto perks,
        String summonerName,
        int teamId,
        String teamPosition,
        int totalDamageDealtToChampions,
        int totalDamageTaken,
        int visionScore,
        boolean win
) {
    public static ParticipantDto from(Participant entity) {
        return new ParticipantDto(
                entity.getAssists(),
                entity.getChampLevel(),
                entity.getChampionId(),
                entity.getChampionName(),
                entity.getDeaths(),
                entity.getItem0(),
                entity.getItem1(),
                entity.getItem2(),
                entity.getItem3(),
                entity.getItem4(),
                entity.getItem5(),
                entity.getItem6(),
                entity.getKills(),
                entity.getParticipantId(),
                entity.getTotalMinionsKilled(),
                entity.getPuuid(),
                entity.getSummonerId(),
                entity.getSummoner1Id(),
                entity.getSummoner2Id(),
                PerksDto.of(entity.getPrimaryPerk(), entity.getSubPerk()),
                entity.getSummonerName(),
                entity.getTeamId(),
                entity.getTeamPosition(),
                entity.getTotalDamageDealtToChampions(),
                entity.getTotalDamageTaken(),
                entity.getVisionScore(),
                entity.isWin()
        );
    }
}
