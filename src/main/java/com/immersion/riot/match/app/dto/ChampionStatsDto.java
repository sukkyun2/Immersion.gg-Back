package com.immersion.riot.match.app.dto;

public record ChampionStatsDto(
        String championName,
        Long totalMatch,
        Long winMatchCount,
        Long loseMatchCount,
        double killAvg,
        double deathAvg,
        double assistAvg
) {
}
