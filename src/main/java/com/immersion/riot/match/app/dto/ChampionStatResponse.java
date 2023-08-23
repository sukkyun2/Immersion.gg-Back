package com.immersion.riot.match.app.dto;

public record ChampionStatResponse(
        String championName,
        String championImageUrl,
        int totalMatch,
        int winMatchCount,
        int loseMatchCount,
        double winRate,
        double killAvg,
        double deathAvg,
        double assistAvg,
        double kda
) {

    public static ChampionStatResponse from(ChampionStatsDto dto, String imageUrl) {

        double winRate = Math.round((double) dto.winMatchCount() / dto.totalMatch() * 10000) / 100.0;
        double roundedKillAvg = Math.round(dto.killAvg() * 100) / 100.0;
        double roundedDeathAvg = Math.round(dto.deathAvg() * 100) / 100.0;
        double roundedAssistAvg = Math.round(dto.assistAvg() * 100) / 100.0;
        double kda = Math.round((dto.killAvg() + dto.assistAvg()) / dto.deathAvg() * 100) / 100.0;

        return new ChampionStatResponse(
                dto.championName(),
                imageUrl + dto.championName() + ".png",
                dto.totalMatch().intValue(),
                dto.winMatchCount().intValue(),
                dto.loseMatchCount().intValue(),
                winRate,
                roundedKillAvg,
                roundedDeathAvg,
                roundedAssistAvg,
                kda
        );
    }
}
