package com.immersion.riot.match.app.dto;

import com.immersion.riot.spectator.domain.enums.QueueType;
import lombok.AllArgsConstructor;

import java.util.List;

public record MatchResponse(
        String gameStartTime,
        String gameDuration,
        QueueType queueType,
        List<ParticipantResponse> participants,
        String winTeam
) {
    public static MatchResponse of(String gameStartTime, String gameDuration, List<ParticipantResponse> participants, String winTeam, QueueType queueType) {
        return new MatchResponse(
                gameStartTime,
                gameDuration,
                queueType,
                participants,
                winTeam
        );
    }

}
