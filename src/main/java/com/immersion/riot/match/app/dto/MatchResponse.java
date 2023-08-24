package com.immersion.riot.match.app.dto;

import com.immersion.riot.match.domain.entity.Participant;
import com.immersion.riot.match.domain.repository.ParticipantRepository;

import java.util.List;

public record MatchResponse(
        String gameDuration,
        List<ParticipantResponse> participants,
        String winTeam
) {
    public static MatchResponse of(String gameDuration, List<ParticipantResponse> participants, String winTeam) {
        return new MatchResponse(
                gameDuration,
                participants,
                winTeam
        );
    }
}
