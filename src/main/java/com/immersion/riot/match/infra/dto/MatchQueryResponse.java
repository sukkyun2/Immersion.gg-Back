package com.immersion.riot.match.infra.dto;

import com.immersion.riot.match.domain.entity.Match;
import com.immersion.riot.match.domain.entity.Participant;
import com.immersion.riot.match.domain.entity.Team;

import java.util.stream.Collectors;

public record MatchQueryResponse(
        MetadataDto metadata,
        InfoDto info
) {

    public Match toEntity() {
        return Match.of(
                metadata().matchId(),
                info.gameStartTimestamp().toLocalDateTime(),
                info.gameDuration(),
                info.queueId(),
                info.gameEndTimestamp().toLocalDateTime(),
                info.participants().stream().map(participantDto ->
                        Participant.of(
                                metadata().matchId(),
                                participantDto.participantId(),
                                participantDto.kills(),
                                participantDto.deaths(),
                                participantDto.assists(),
                                participantDto.item0(),
                                participantDto.item1(),
                                participantDto.item2(),
                                participantDto.item3(),
                                participantDto.item4(),
                                participantDto.item5(),
                                participantDto.item6(),
                                participantDto.champLevel(),
                                participantDto.championId(),
                                participantDto.championName(),
                                participantDto.puuid(),
                                participantDto.summonerId(),
                                participantDto.summonerName().toLowerCase(),
                                participantDto.teamId(),
                                participantDto.teamPosition(),
                                participantDto.totalDamageDealtToChampions(),
                                participantDto.totalDamageTaken(),
                                participantDto.visionScore(),
                                participantDto.win(),
                                participantDto.summoner1Id(),
                                participantDto.summoner2Id(),
                                participantDto.perks().styles().get(0).style(),
                                participantDto.perks().styles().get(1).style(),
                                participantDto.totalMinionsKilled(),
                                info.queueId()
                        )
                ).collect(Collectors.toList()),
                getWinTeamId(),
                info.teams().stream().map(teamDto ->
                        Team.of(metadata.matchId(),
                                teamDto.teamId(),
                                teamDto.objectives().baron().kills(),
                                teamDto.objectives().dragon().kills()))
                        .collect(Collectors.toList())
        );
    }

    private String getWinTeamId() {
        TeamQeuryDto team1 = info.teams().get(0);

        if (team1.win()) return team1.teamId();

        return info.teams().get(1).teamId();
    }
}
