package com.immersion.riot.match.infra.dto;

import java.util.List;

public record MetadataDto(
        String matchId,
        List<String> participants
) {
}
