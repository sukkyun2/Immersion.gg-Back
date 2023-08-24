package com.immersion.riot.match.infra.service;

import com.immersion.riot.match.domain.repository.MatchRepository;
import com.immersion.riot.match.infra.client.MatchClient;
import com.immersion.riot.match.infra.dto.MatchRequest;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.ZoneOffset;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class RiotMatchCreateService {

    private final MatchClient matchClient;
    private final MatchRepository matchRepository;

    public void saveAllMatch(String puuid, MatchRequest matchRequest) {
        matchClient.getMatchList(puuid, matchRequest)
                .forEach(this::saveMatchInfo);
    }

    private void saveMatchInfo(String matchId) {

        if (matchRepository.existsById(matchId)) {
            log.info("이미 존재하는 Match 정보입니다 : {}, message : {}", matchId);
            return;
        }
        matchRepository.save(matchClient.getMatchInfo(matchId).toEntity());
    }
}
