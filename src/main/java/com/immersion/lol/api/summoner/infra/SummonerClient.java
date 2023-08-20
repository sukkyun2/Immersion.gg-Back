package com.immersion.lol.api.summoner.infra;

import com.immersion.lol.config.RiotFeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "summoner", configuration = RiotFeignConfiguration.class, url = "${riot.api.url.kr}")
public interface SummonerClient {
    @GetMapping("/lol/summoner/v4/summoners/by-name/{summonerName}")
    Optional<Summoner> getSummoner(@PathVariable String summonerName);
}
