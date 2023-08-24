package com.immersion.riot.match.api;

import com.immersion.riot.match.app.dto.MatchDto;
import com.immersion.riot.match.app.dto.MatchResponse;
import com.immersion.riot.match.app.dto.ParticipantResponse;
import com.immersion.riot.match.app.service.ImageUrlBuilderService;
import com.immersion.riot.match.query.MatchQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MatchQueryApi {

    private final MatchQueryService matchQueryService;

    @GetMapping("/match/{puuid}")
    public ResponseEntity<Page<MatchResponse>> getMatchListByPuuid(
            @PathVariable String puuid,
            @PageableDefault(sort = "gameEndTime", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<MatchResponse> matchList = matchQueryService.getMatchList(puuid, pageable);

        return ResponseEntity.ok(matchList);
    }
}
