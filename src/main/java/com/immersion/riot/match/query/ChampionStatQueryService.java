package com.immersion.riot.match.query;

import com.immersion.riot.match.app.dto.ChampionStatsDto;
import com.immersion.riot.match.domain.repository.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChampionStatQueryService {

    private final ParticipantRepository participantRepository;

    public List<ChampionStatsDto> getMostChampionByPuuid(String puuid) {
        return participantRepository.getChampionStats(puuid);
    }

}
