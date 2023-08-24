package com.immersion.riot.match.infra.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;
import java.util.Map;

public record SummonerCastQueryResponse(
        Map<String, SummonerCastDto> data
) {
}
