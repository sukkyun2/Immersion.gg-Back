package com.immersion.riot.match.app.dto;

import com.immersion.riot.match.domain.entity.Match;
import com.immersion.riot.match.infra.dto.ParticipantDto;

import java.time.LocalDateTime;
import java.util.List;

public record MatchDto(
        String MatchId,
        LocalDateTime gameStartTime,
        LocalDateTime gameEndTime,
        long gameDuration,
        List<ParticipantDto> participants,
        String winTeam
) {
    public static MatchDto from(Match entity) {
        return new MatchDto(
                entity.getMatchId(),
                entity.getGameStartTime(),
                entity.getGameEndTime(),
                entity.getGameDuration(),
                entity.getParticipants().stream()
                        .map(ParticipantDto::from)
                        .toList(),
                entity.getWinTeam()
        );
    }
}
