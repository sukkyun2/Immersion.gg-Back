package com.immersion.riot.match.app.dto;

public record ChampionStatsDto(
        String championName,
        int championId,
        Long totalMatch,
        Long winMatchCount,
        Long loseMatchCount,
        double killAvg,
        double deathAvg,
        double assistAvg
) {
}
