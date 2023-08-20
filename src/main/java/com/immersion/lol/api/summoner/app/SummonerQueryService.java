package com.immersion.lol.api.summoner.app;

import com.immersion.lol.api.summoner.infra.SummonerClient;
import com.immersion.lol.common.app.NoDataException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SummonerQueryService {
    private final SummonerClient summonerClient;

    public SummonerQueryResponse getSummoner(String summonerName){
        return summonerClient.getSummoner(summonerName)
                .map(SummonerQueryResponse::new)
                .orElseThrow(NoDataException::new);
    }
}
