package com.immersion.riot.match.app.dto;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public record InfoDto(
        Timestamp gameStartTimestamp,
        Timestamp gameDuration,
        Timestamp gameEndTimestamp,
        List<ParticipantDto> participants,
        List<TeamDto> teams
) {
}
