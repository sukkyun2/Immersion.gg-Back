package com.immersion.riot.match.app.dto;

import com.immersion.riot.match.domain.entity.Team;

public record TeamDto(
        String teamId,
        int baronKill,
        int dragonKill
) {

    public static TeamDto from(Team entity) {
        return new TeamDto(
                entity.getTeamId(),
                entity.getBaronKill(),
                entity.getDragonKill()
        );
    }
}
