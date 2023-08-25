package com.immersion.riot.match.app.service;

import com.immersion.riot.match.app.dto.ChampionWinRateResponse;
import com.immersion.riot.match.domain.entity.Match;
import com.immersion.riot.match.domain.entity.Participant;
import com.immersion.riot.match.domain.repository.MatchRepository;
import com.immersion.riot.match.app.dto.ChampionWinRateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class WinRateAnalysisService {

    private final MatchRepository matchRepository;
    private final ImageUrlBuilderService imageUrlBuilderService;

    public Map<String, ChampionWinRateResponse> caculateWinRate(String puuid, String championName) {
        List<Match> matchList = matchRepository.getMatchIdByPuuidAndChampionId(puuid, championName);

        return calculateWinRate(matchList, puuid).entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> ChampionWinRateResponse.from(
                                entry.getValue(),
                                imageUrlBuilderService.getChampionImageUrlByName(entry.getKey()))
                ));
    }

    private Map<String, ChampionWinRateDto> calculateWinRate(List<Match> matchList, String puuid) {
        Map<String, ChampionWinRateDto> championWinRateMap = new HashMap<>();

        for (Match match : matchList) {
            Participant me = match.getParticipants().stream()
                    .filter(participant -> participant.getPuuid().equals(puuid))
                    .findFirst()
                    .orElse(null);

            if (me == null || me.getTeamPosition().isBlank()) { //협곡이 아닐 경우에는 팀포지션 없음
                continue;
            }

            match.getParticipants().stream()
                    .filter(participant -> participant.getTeamPosition().equals(me.getTeamPosition()) && participant.getTeamId() != me.getTeamId())
                    .forEach(participant -> {
                        championWinRateMap
                                .computeIfAbsent(participant.getChampionName(), k -> new ChampionWinRateDto())
                                .incrementTotalMatches()
                                .incrementWins(participant.isWin() ? 0 : 1);
                    });
        }
        return championWinRateMap;
    }
}
