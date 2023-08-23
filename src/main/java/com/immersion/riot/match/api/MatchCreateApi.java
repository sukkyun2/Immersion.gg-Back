package com.immersion.riot.match.api;

import com.immersion.riot.match.infra.service.RiotMatchCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MatchCreateApi {

    private final RiotMatchCreateService riotMatchService;

    @PostMapping("/match/{puuid}")
    public ResponseEntity<String> saveAllMatch(@PathVariable String puuid, long startTime, int count) {
        riotMatchService.saveAllMatch(puuid, startTime, count);
        return ResponseEntity.ok("save complete!");
    }
}
