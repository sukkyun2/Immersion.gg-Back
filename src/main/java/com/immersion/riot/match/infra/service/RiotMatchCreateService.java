package com.immersion.riot.match.infra.service;

import com.immersion.riot.match.domain.repository.MatchRepository;
import com.immersion.riot.match.infra.client.MatchClient;
import jakarta.persistence.EntityExistsException;
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
        try {
            matchRepository.save(matchClient.getMatchInfo(matchId).toEntity());
        } catch (EntityExistsException e) {
            log.info("이미 존재하는 Match 정보입니다 : {}, message : {}", matchId, e.getMessage());
        }
    }

}
