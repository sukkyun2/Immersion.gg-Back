package com.immersion.riot.match.app.dto;

import java.util.List;

public record MetadataDto(
        String matchId,
        List<String> participants
) {
}
