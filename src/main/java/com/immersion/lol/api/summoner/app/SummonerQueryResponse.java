package com.immersion.lol.api.summoner.app;

import com.immersion.lol.api.summoner.infra.Summoner;

import java.time.LocalDateTime;

public record SummonerQueryResponse(
        String id,
        String accountId,
        String puuid,
        String name,
        String profileIconUrl,
        LocalDateTime revisionDate,
        Integer summonerLevel
) {

    public SummonerQueryResponse(Summoner summoner) {
        this(summoner.id(),
                summoner.accountId(),
                summoner.puuid(),
                summoner.name(),
                "", //TODO 가공하는 로직
                summoner.getRevisionDate(),
                summoner.summonerLevel());
    }
}