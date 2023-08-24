package com.immersion.riot.match.query;

import com.immersion.riot.common.app.NoDataException;
import com.immersion.riot.match.app.dto.ChampionStatResponse;
import com.immersion.riot.match.app.dto.ChampionStatsDto;
import com.immersion.riot.match.app.service.ImageUrlBuilderService;
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

        List<ChampionStatsDto> championStats = participantRepository.getChampionStats(puuid);

        if (championStats.isEmpty()) {
            throw new NoDataException("해당하는 유저의 챔피언 통계를 가져올 수 없습니다 puuid - "+ puuid);
        }

        return championStats.stream()
                .map(dto -> ChampionStatResponse.from(
                        dto,
                        imageUrlBuilderService.getChampionImageUrl(dto.championId()))
                ).toList();
    }

}
