package com.immersion.riot.match.query;

import com.immersion.riot.match.app.dto.ChampionStatResponse;
import com.immersion.riot.match.app.dto.ChampionStatsDto;
import com.immersion.riot.match.app.service.ImageUrlBuilderService;
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
    private final ImageUrlBuilderService imageUrlBuilderService;


    public List<ChampionStatResponse> getMostChampionByPuuid(String puuid) {
        return participantRepository.getChampionStats(puuid).stream()
                .map(dto -> ChampionStatResponse.from(
                        dto, imageUrlBuilderService.getChampionImageUrl(dto.championId()))
                )
                .toList();
    }

}
