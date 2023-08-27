package com.immersion.riot.match.app.dto;

import com.immersion.riot.match.domain.entity.Team;

public record TeamResponse(
        String teamId,
        int baronKill,
        int dragonKill
) {

    public static TeamResponse from(TeamDto dto) {
        return new TeamResponse(
                dto.teamId(),
                dto.baronKill(),
                dto.dragonKill()
        );
    }
}
