package com.immersion.riot.match.infra.service;

import com.immersion.riot.match.domain.entity.Match;
import com.immersion.riot.match.domain.entity.Participant;
import com.immersion.riot.match.domain.repository.MatchRepository;
import com.immersion.riot.match.domain.repository.ParticipantRepository;
import com.immersion.riot.match.infra.client.MatchClient;
import com.immersion.riot.match.infra.dto.MatchRequest;
import io.micrometer.core.instrument.util.AbstractPartition;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiotMatchCreateService {

    private final MatchClient matchClient;
    private final MatchRepository matchRepository;
    private final ParticipantRepository participantRepository;

    public void saveAllMatch(String puuid, MatchRequest matchRequest) {

        List<Match> matchList = matchClient.getMatchList(puuid, matchRequest).stream()
                .filter(matchId -> !matchRepository.existsById(matchId))
                .map(matchId -> matchClient.getMatchInfo(matchId).toEntity())
                .toList();

        List<Participant> participants = matchList.stream()
                .flatMap(match -> match.getParticipants().stream())
                .toList();

        participantRepository.saveAll(participants);
        matchRepository.saveAll(matchList);
    }
}
