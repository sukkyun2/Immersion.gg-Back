package com.immersion.riot.match.infra.service;

import com.immersion.riot.match.domain.repository.MatchRepository;
import com.immersion.riot.match.infra.client.MatchClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiotMatchCreateService {

    private final MatchClient matchClient;
    private final MatchRepository matchRepository;

    public void saveAllMatch(String puuid, long startTime, int count) {
        matchClient.getMatchList(puuid, startTime, count)
                .forEach(this::saveMatchInfo);
    }

    private void saveMatchInfo(String matchId) {
        matchRepository.save(matchClient.getMatchInfo(matchId).toEntity());
    }

}
