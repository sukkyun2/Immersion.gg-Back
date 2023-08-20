package com.immersion.lol.api.summoner.api;

import com.immersion.lol.api.summoner.app.SummonerQueryResponse;
import com.immersion.lol.api.summoner.app.SummonerQueryService;
import com.immersion.lol.common.app.NoDataException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SummonerQueryApi {
    private final SummonerQueryService summonerQueryService;

    @GetMapping("/api/lol/v1/summoners/{summonerName}")
    public ResponseEntity<SummonerQueryResponse> getSummoner(@PathVariable String summonerName) {
        try {
            return ResponseEntity.ok(summonerQueryService.getSummoner(summonerName));
        } catch (NoDataException e) {
            return ResponseEntity.noContent().build();
        }
    }
}
