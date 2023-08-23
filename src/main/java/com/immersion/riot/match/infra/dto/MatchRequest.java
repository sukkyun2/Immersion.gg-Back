package com.immersion.riot.match.infra.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Builder
@Getter
public class MatchRequest {

    private long startTime;

    @Builder.Default
    private int count = 50;
}
