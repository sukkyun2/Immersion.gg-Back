package com.immersion.riot.match.domain.repository;

import com.immersion.riot.match.infra.dto.MatchQueryResponse;
import com.immersion.riot.match.domain.entity.Match;
import com.immersion.riot.match.infra.client.MatchClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MatchRepositoryTest {

    @Autowired
    MatchClient matchClient;

    @Autowired
    MatchRepository matchRepository;

    @Test
    @DisplayName("MatchQueryResponse 엔티티 변환 후 저장 ")
    public void givenMatchId_whenInvokeGameInfo_thenReturnGameInfo() throws Exception {

        //Given
        String matchId = "KR_6629711662";
        //When
        MatchQueryResponse matchInfo = matchClient.getMatchInfo(matchId);
        Match match = matchInfo.toEntity();
        Match savedMatch = matchRepository.save(match);
        //then
        System.out.println("savedMatch = " + savedMatch);
        System.out.println("savedMatch.getParticipants() = " + savedMatch.getParticipants());
    }

}