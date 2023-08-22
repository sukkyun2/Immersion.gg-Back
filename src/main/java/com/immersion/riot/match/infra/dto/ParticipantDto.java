package com.immersion.riot.match.infra.dto;

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
        String puuid,
        String summonerId,
        String summonerName,
        int teamId,
        String teamPosition,
        int totalDamageDealtToChampions,
        int totalDamageTaken,
        int visionScore,
        boolean win
) {
}
