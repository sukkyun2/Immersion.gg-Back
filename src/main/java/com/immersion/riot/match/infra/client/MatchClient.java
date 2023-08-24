package com.immersion.riot.match.infra.client;

import com.immersion.riot.config.RiotFeignConfiguration;
import com.immersion.riot.match.infra.dto.MatchQueryResponse;
import com.immersion.riot.match.infra.dto.MatchRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "match", url = "${riot.api.url.asia}", configuration = RiotFeignConfiguration.class)
public interface MatchClient {

    @GetMapping("/lol/match/v5/matches/by-puuid/{puuid}/ids")
    List<String> getMatchList(@PathVariable String puuid, @SpringQueryMap MatchRequest matchRequest);

    @GetMapping("/lol/match/v5/matches/{matchId}")
    MatchQueryResponse getMatchInfo(@PathVariable String matchId);



}
