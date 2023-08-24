package com.immersion.riot.match.infra.dto;

import java.util.List;

public record PerksDto(
        List<PerksStyleDto> styles
) {
    public static PerksDto of(int primaryPerk, int subPerk) {
        return new PerksDto(List.of(
                new PerksStyleDto("primaryStyle", primaryPerk),
                new PerksStyleDto("subStyle", subPerk)
        ));
    }
}
