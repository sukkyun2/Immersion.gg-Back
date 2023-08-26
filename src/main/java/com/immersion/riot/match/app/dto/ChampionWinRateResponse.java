package com.immersion.riot.match.app.dto;

public record ChampionWinRateResponse(
        String championImageUrl,
        int totalMatch,
        double winRate
) {

    public static ChampionWinRateResponse from(ChampionWinRateDto dto, String championImageUrl) {
        return new ChampionWinRateResponse(
                championImageUrl,
                dto.getTotalMatches(),
                dto.calcWinRate()
        );
    }
}
