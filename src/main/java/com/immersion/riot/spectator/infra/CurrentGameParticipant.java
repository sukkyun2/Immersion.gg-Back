package com.immersion.riot.spectator.infra;

import java.util.List;

public record CurrentGameParticipant(
        String championId,
        String profileIconId,
        boolean bot,
        String teamId,
        String summonerName,
        String summonerId,
        String spell1Id,
        String spell2Id,
        List<GameCustomizationObject> gameCustomizationObjects

) {
}
