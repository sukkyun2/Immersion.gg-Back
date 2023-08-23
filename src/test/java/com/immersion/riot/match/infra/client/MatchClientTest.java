package com.immersion.riot.match.infra.client;

import com.immersion.riot.match.infra.dto.MatchQueryResponse;
import com.immersion.riot.match.infra.dto.MatchRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
class MatchClientTest {

    @Autowired
    MatchClient matchClient;

    @Test
    @DisplayName("matchId로 조회시 게임정보 반환")
    public void givenMatchId_whenInvokeGameInfo_thenReturnGameInfo() throws Exception {

        //Given
        String matchId = "KR_6629711662";
        //When
        MatchQueryResponse matchInfo = matchClient.getMatchInfo(matchId);

        //then
        assertThat(matchInfo).hasNoNullFieldsOrProperties();

    }

    @Test
    @DisplayName("소환사 puuid로 조회시 MatchId List 반환")
    public void givenPuuid_whenInvokeMatchList_thenReturnMatchList() throws Exception {

        //Given
        String puuid = "nWNJ3TFBikpBRHO6o1jMQTeY8T9lwCeKAq73WzxB3iTKcMnFTjQ8mElAWg4R38jLuTuvEheG6eIAcw";
        //When
        List<String> matchList = matchClient.getMatchList(puuid, MatchRequest.builder().build());
        //Then
        assertThat(matchList).isNotEmpty();

    }

}