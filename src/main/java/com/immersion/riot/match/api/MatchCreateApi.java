package com.immersion.riot.match.api;

import com.immersion.riot.match.app.dto.ChampionStatResponse;
import com.immersion.riot.match.app.dto.ChampionStatsDto;
import com.immersion.riot.match.infra.service.RiotMatchService;
import com.immersion.riot.match.query.ChampionStatQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MatchCreateApi {

    private final RiotMatchService riotMatchService;
    private final ChampionStatQueryService championStatQueryService;

    @GetMapping("/match/save/{puuid}")
    public ResponseEntity<String> saveAllMatch(@PathVariable String puuid, long startTime, int count) {
        riotMatchService.saveAllMatch(puuid, startTime, count);
        return ResponseEntity.ok().body("save!");
    }

    @GetMapping("/match/most/{puuid}")
    public ResponseEntity<List<ChampionStatResponse>> getMostChampionsByPuuid(@PathVariable String puuid) {
        List<ChampionStatResponse> championStatResponses = championStatQueryService.getMostChampionByPuuid(puuid).stream()
                .map(ChampionStatResponse::from)
                .toList();

        return ResponseEntity.ok().body(championStatResponses);
    }

}
