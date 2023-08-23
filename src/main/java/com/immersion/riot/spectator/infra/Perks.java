package com.immersion.riot.spectator.infra;

import java.util.List;

public record Perks(
        List<String> perkIds,
        String perkStyle,
        String perkSubStyle
) {
}
