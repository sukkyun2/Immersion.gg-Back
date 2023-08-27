package com.immersion.riot.match.infra.dto;

public record TeamQeuryDto(
        String teamId,
        ObjectivesDto objectives,
        boolean win
) {
}
