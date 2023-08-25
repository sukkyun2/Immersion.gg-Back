package com.immersion.riot.match.query;

import com.immersion.riot.common.app.NoDataException;
import com.immersion.riot.match.app.dto.ChampionStatResponse;
import com.immersion.riot.match.app.dto.ChampionStatsDto;
import com.immersion.riot.match.app.dto.ChampionWinRateDto;
import com.immersion.riot.match.app.service.ImageUrlBuilderService;
import com.immersion.riot.match.domain.entity.Participant;
import com.immersion.riot.match.domain.repository.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ChampionStatQueryService {

    private final ParticipantRepository participantRepository;
    private final ImageUrlBuilderService imageUrlBuilderService;


    public List<ChampionStatResponse> getMostChampionByPuuid(String puuid) {

        List<ChampionStatsDto> championStats = participantRepository.getChampionStatsByPuuid(puuid);

        return championStats.stream()
                .map(dto -> ChampionStatResponse.from(
                        dto,
                        imageUrlBuilderService.getChampionImageUrl(dto.championId()))
                ).toList();
    }

    public List<ChampionStatResponse> getMostChampionBySummonerName(String summonerName) {

        List<ChampionStatsDto> championStats = participantRepository.getChampionStatsBySummonerName(summonerName);

        return championStats.stream()
                .map(dto -> ChampionStatResponse.from(
                        dto,
                        imageUrlBuilderService.getChampionImageUrl(dto.championId()))
                ).toList();
    }

    public ChampionWinRateDto getChampionStatistics(String puuid, Integer championId){
        List<Participant> participants = participantRepository.findAllByPuuidAndChampionId(puuid, championId);
        long winCount = participants.stream().filter(Participant::isWin).count();

        return new ChampionWinRateDto(participants.size(), (int) winCount);
    }

}
