package com.immersion.riot.match.api;

import com.immersion.riot.match.app.dto.MatchDto;
import com.immersion.riot.match.app.dto.MatchResponse;
import com.immersion.riot.match.app.dto.ParticipantResponse;
import com.immersion.riot.match.app.service.ImageUrlBuilderService;
import com.immersion.riot.match.query.MatchQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MatchQueryApi {

    private final MatchQueryService matchQueryService;
    private final ImageUrlBuilderService imageUrlBuilderService;

    @GetMapping("/match/{puuid}")
    public ResponseEntity<List<MatchResponse>> getMatchListByPuuid(@PathVariable String puuid) {
        List<MatchDto> matchList = matchQueryService.getMatchList(puuid);

        List<MatchResponse> matchResponseList = matchList.stream()
                .map(matchDto -> MatchResponse.of(
                        formatGameDuration(matchDto.gameDuration()),
                        matchDto.participants().stream()
                                .map(participantDto -> ParticipantResponse.of(
                                        imageUrlBuilderService.getChampionImageUrl(participantDto.championId()),
                                        participantDto.summonerName(),
                                        participantDto.champLevel(),
                                        participantDto.teamPosition(),
                                        participantDto.kills(),
                                        participantDto.deaths(),
                                        participantDto.assists(),
                                        caculateKDA(participantDto.kills(), participantDto.deaths(), participantDto.assists()),
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
                        matchDto.winTeam())).toList();

        return ResponseEntity.ok(matchResponseList);
    }


    private double caculateKDA(int kill, int death, int assist) {
        return Math.round((kill + assist) / (double) death * 100) / 100.0;
    }

    private String formatGameDuration(long gameDuration) {
        long minute = gameDuration / 60;
        long second = gameDuration % 60;

        return String.format("%02d:%02d", minute, second);
    }

}
