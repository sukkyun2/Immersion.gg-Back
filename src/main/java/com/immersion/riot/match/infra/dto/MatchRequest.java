package com.immersion.riot.match.infra.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MatchRequest {

    private long startTime;
    private int count;
}
