package com.immersion.riot.match.app.dto;

import com.immersion.riot.spectator.domain.enums.QueueType;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public record MatchResponse(
        LocalDateTime gameStartTime,
        String gameDuration,
        QueueType queueType,
        List<ParticipantResponse> participants,
        String winTeam,
        List<TeamResponse> teams
) {
    public static MatchResponse of(LocalDateTime gameStartTime, String gameDuration, List<ParticipantResponse> participants, String winTeam, QueueType queueType, List<TeamResponse> teams) {
        return new MatchResponse(
                gameStartTime,
                gameDuration,
                queueType,
                participants,
                winTeam,
                teams
        );
    }

}
