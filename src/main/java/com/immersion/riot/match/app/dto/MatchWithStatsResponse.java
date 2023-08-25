package com.immersion.riot.match.app.dto;

import org.springframework.data.domain.Slice;
import java.util.List;

public record MatchWithStatsResponse(
        Slice<MatchResponse> matchResponses,
        List<ChampionStatResponse> championStatResponses
) {

    public static MatchWithStatsResponse of(Slice<MatchResponse> matchResponses, List<ChampionStatResponse> championStatResponses) {
        return new MatchWithStatsResponse(matchResponses, championStatResponses);
    }
}
