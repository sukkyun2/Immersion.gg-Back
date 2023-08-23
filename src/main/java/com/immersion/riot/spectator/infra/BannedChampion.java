package com.immersion.riot.spectator.infra;

public record BannedChampion(
        int pickTurn,
        String championId,
        String teamId
) {
}
