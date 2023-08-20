package com.immersion.lol.api.summoner.infra;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public record Summoner(
        String id,
        String accountId,
        String puuid,
        String name,
        Integer profileIconId,
        Timestamp revisionDate,
        Integer summonerLevel
) {

    public LocalDateTime getRevisionDate() {
        return revisionDate.toLocalDateTime();
    }
}
