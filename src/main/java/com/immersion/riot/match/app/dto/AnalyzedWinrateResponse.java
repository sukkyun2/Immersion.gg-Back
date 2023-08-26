package com.immersion.riot.match.app.dto;

import java.util.Map;

public record AnalyzedWinrateResponse(
        Map<String, ChampionWinRateResponse> championWinRateResponseMap,
        String gptAnswer
) {

        public static AnalyzedWinrateResponse of(Map<String, ChampionWinRateResponse> championWinRateResponseMap, String gptAnswer) {
            return new AnalyzedWinrateResponse(
                    championWinRateResponseMap,
                    gptAnswer
            );
        }
}
