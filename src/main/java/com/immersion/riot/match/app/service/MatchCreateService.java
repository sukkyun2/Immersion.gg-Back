package com.immersion.riot.match.app.service;

import com.immersion.riot.match.domain.entity.MatchUpdateHistory;
import com.immersion.riot.match.domain.repository.MatchRepository;
import com.immersion.riot.match.domain.repository.MatchUpdateHistoryRepository;
import com.immersion.riot.match.infra.dto.MatchRequest;
import com.immersion.riot.match.infra.service.RiotMatchCreateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
@RequiredArgsConstructor
@Slf4j
public class MatchCreateService {

    private final RiotMatchCreateService riotMatchCreateService;
    private final MatchUpdateHistoryRepository matchUpdateHistoryRepository;

    public void saveMatchList(String puuid) {
        if (!matchUpdateHistoryRepository.existsById(puuid)) {
            matchUpdateHistoryRepository.save(
                    MatchUpdateHistory.of(puuid, LocalDateTime.now())
            );
            MatchRequest matchRequest = MatchRequest.builder()
                    .build();
            riotMatchCreateService.saveAllMatch(puuid, matchRequest);
            return;
        }

        MatchUpdateHistory history = matchUpdateHistoryRepository.getReferenceById(puuid);
        MatchRequest matchRequest = MatchRequest.builder()
                .startTime(history.getLastUpdateTime().toEpochSecond(ZoneOffset.UTC))
                .build();
        history.updateLastUpdateTime(LocalDateTime.now());
        riotMatchCreateService.saveAllMatch(puuid, matchRequest);

    }

}
