package com.immersion.riot.match.infra.client;

import com.immersion.riot.match.infra.dto.ChampionDto;
import com.immersion.riot.match.infra.dto.ChampionQueryResponse;
import com.immersion.riot.match.infra.dto.SummonerCastQueryResponse;
import com.immersion.riot.match.infra.dto.SummonerPerksQueryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "cdn", url = "${riot.api.url.cdn}")
public interface CdnClient {
    @GetMapping("/{version}/data/en_US/summoner.json")
    SummonerCastQueryResponse getSummonerCast(@PathVariable String version);

    @GetMapping("/{version}/data/en_US/runesReforged.json")
    List<SummonerPerksQueryResponse> getSummonerPerk(@PathVariable String version);

    @GetMapping("/{version}/data/en_US/champion.json")
    ChampionQueryResponse getChampion(@PathVariable String version);
}
