package com.immersion.riot.match.app.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.immersion.riot.match.app.dto.ChampionWinRateResponse;
import com.immersion.riot.match.domain.entity.Match;
import com.immersion.riot.match.domain.entity.Participant;
import com.immersion.riot.match.domain.repository.MatchRepository;
import com.immersion.riot.match.app.dto.ChampionWinRateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class WinRateAnalysisService {

    private final MatchRepository matchRepository;
    private final ImageUrlBuilderService imageUrlBuilderService;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    private static final String TOPIC = "chatGpt";

    public Map<String, ChampionWinRateResponse> getAnalyzedWinRate(String puuid, String championName) throws JSONException, JsonProcessingException {
        List<Match> matchList = matchRepository.getMatchIdByPuuidAndChampionId(puuid, championName);

        return calculateWinRate(matchList, puuid, championName).entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> ChampionWinRateResponse.from(
                                entry.getValue(),
                                imageUrlBuilderService.getChampionImageUrlByName(entry.getKey())),
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
    }

    private Map<String, ChampionWinRateDto> calculateWinRate(List<Match> matchList, String puuid, String championName) throws JSONException, JsonProcessingException {
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

        sendToKafka(puuid, championName, championWinRateMap);

        return championWinRateMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Comparator.comparingDouble(o -> o.getValue().getTotalMatches())))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));


    }

    private void sendToKafka(String puuid, String championName, Map<String, ChampionWinRateDto> winRateMap) throws JSONException, JsonProcessingException {
        JSONObject msgData = new JSONObject();
        msgData.put("puuid", puuid);
        msgData.put("championName", championName);
        msgData.put("winRateMap", objectMapper.writeValueAsString(winRateMap));

        kafkaTemplate.send(TOPIC, msgData.toString(4) );
    }
}
