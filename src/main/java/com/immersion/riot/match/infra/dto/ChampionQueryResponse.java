package com.immersion.riot.match.infra.dto;

import java.util.Map;

public record ChampionQueryResponse(
        Map<String, ChampionDto> data
) {
}
