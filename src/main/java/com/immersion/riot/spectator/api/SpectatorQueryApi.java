package com.immersion.riot.spectator.api;

import com.immersion.riot.spectator.app.SpectatorQueryResponse;
import com.immersion.riot.spectator.app.SpectatorQueryService;
import com.immersion.riot.common.app.NoDataException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SpectatorQueryApi {
    private final SpectatorQueryService spectatorQueryService;

    @GetMapping("/lol/spectator/v4/active-games/by-summoner/{encryptedSummonerId}")
    public ResponseEntity<SpectatorQueryResponse> getSpectator(@PathVariable String encryptedSummonerId) {
        try {
            SpectatorQueryResponse response = spectatorQueryService.getSpectator(encryptedSummonerId);
            return ResponseEntity.ok(response);
        } catch (NoDataException e) {
            return ResponseEntity.noContent().build();
        }
    }
}
