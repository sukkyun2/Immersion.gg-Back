package com.immersion.riot.spectator.infra;

import java.sql.Timestamp;
import java.util.List;

public record CurrentGameInfo(
    String gameId,
    String gameType,
    Timestamp gameStartTime,
    String mapId,
    String gameLength,
    String platformId,
    String gameMode,
    List<BannedChampion> bannedChampions,
    String gameQueueConfigId,
    List<CurrentGameParticipant> participants
    )
{
}
