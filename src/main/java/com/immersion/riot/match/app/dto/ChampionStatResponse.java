package com.immersion.riot.match.app.dto;

public record ChampionStatResponse(
        String championName,
        String championImageUrl,
        Long totalMatch,
        Long winMatchCount,
        Long loseMatchCount,
        double killAvg,
        double deathAvg,
        double assistAvg,
        double kda
) {

    public static ChampionStatResponse from(ChampionStatsDto dto) {
        return new ChampionStatResponse(
                dto.championName(),
                "http://ddragon.leagueoflegends.com/cdn/13.16.1/img/champion/" + dto.championName() + ".png",
                dto.totalMatch(),
                dto.winMatchCount(),
                dto.loseMatchCount(),
                dto.killAvg(),
                dto.deathAvg(),
                dto.assistAvg(),
                Math.round(dto.killAvg() + dto.assistAvg() / dto.deathAvg() * 100) / 100.0
        );
    }

}
