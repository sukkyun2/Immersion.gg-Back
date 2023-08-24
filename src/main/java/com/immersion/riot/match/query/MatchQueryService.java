package com.immersion.riot.match.query;

import com.immersion.riot.common.app.NoDataException;
import com.immersion.riot.match.app.dto.MatchDto;
import com.immersion.riot.match.app.dto.MatchResponse;
import com.immersion.riot.match.app.dto.ParticipantResponse;
import com.immersion.riot.match.app.service.ImageUrlBuilderService;
import com.immersion.riot.match.domain.entity.Match;
import com.immersion.riot.match.domain.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MatchQueryService {

    private final MatchRepository matchRepository;
    private final ImageUrlBuilderService imageUrlBuilderService;

    public Page<MatchResponse> getMatchList(String puuid, Pageable pageable) {
        Page<MatchDto> matchList = matchRepository.getMatchListByPuuid(puuid, pageable).map(MatchDto::from);

        if (matchList.isEmpty()) {
            log.info("해당하는 소환사의 전적을 조회 할 수 없습니다 - puuid: {}", puuid);
            throw new NoDataException("no match history");
        }

        return dtoToResponse(matchList);
    }

    private Page<MatchResponse> dtoToResponse(Page<MatchDto> matchList) {
        return matchList.map(matchDto -> MatchResponse.of(
                matchDto.formatGameDuration(),
                matchDto.participants().stream()
                        .map(participantDto -> ParticipantResponse.of(
                                imageUrlBuilderService.getChampionImageUrl(participantDto.championId()),
                                participantDto.summonerName(),
                                participantDto.champLevel(),
                                participantDto.teamPosition(),
                                participantDto.kills(),
                                participantDto.deaths(),
                                participantDto.assists(),
                                participantDto.caculateKDA(),
                                participantDto.win(),
                                participantDto.visionScore(),
                                participantDto.totalMinionsKilled(),
                                imageUrlBuilderService.getSpellImageUrl(participantDto.summoner1Id()),
                                imageUrlBuilderService.getSpellImageUrl(participantDto.summoner2Id()),
                                imageUrlBuilderService.getPerkImageUrl(participantDto.perks().styles().get(0).style()),
                                imageUrlBuilderService.getPerkImageUrl(participantDto.perks().styles().get(1).style()),
                                imageUrlBuilderService.getItemImageUrl(participantDto.item0()),
                                imageUrlBuilderService.getItemImageUrl(participantDto.item1()),
                                imageUrlBuilderService.getItemImageUrl(participantDto.item2()),
                                imageUrlBuilderService.getItemImageUrl(participantDto.item3()),
                                imageUrlBuilderService.getItemImageUrl(participantDto.item4()),
                                imageUrlBuilderService.getItemImageUrl(participantDto.item5())
                        )).toList(),
                matchDto.winTeam()));
    }
}
