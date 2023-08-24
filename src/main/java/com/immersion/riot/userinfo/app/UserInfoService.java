package com.immersion.riot.userinfo.app;

import com.immersion.riot.userinfo.infra.dto.LeagueEntryDTO;
import com.immersion.riot.userinfo.infra.dto.SummonerDTO;
import com.immersion.riot.userinfo.infra.client.UserInfoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserInfoService {

    private final UserInfoClient userInfoClient;

    public List<LeagueEntryResponse> getSummonerRank(String encryptedSummonerId) {
        List<LeagueEntryDTO> summonerLeague = userInfoClient.getSummonerLeague(encryptedSummonerId);
        List<LeagueEntryResponse> summonerRank = new ArrayList<>();

        for (LeagueEntryDTO league : summonerLeague) {
            LeagueEntryResponse leagueEntryResponse = new LeagueEntryResponse();
            leagueEntryResponse.setQueueType(league.queueType());
            leagueEntryResponse.setRank(league.rank());
            leagueEntryResponse.setTier(league.tier());
            leagueEntryResponse.setLeaguePoints(league.leaguePoints());
            summonerRank.add(leagueEntryResponse);
        }

        return summonerRank;
    }

    public UserInfoResponse getSummonerInfo(String summonerName) {
        SummonerDTO summonerDTO = userInfoClient.getSummoner(summonerName);
        UserInfoResponse userInfo = new UserInfoResponse();

        userInfo.setProfileIconId(summonerDTO.profileIconId());
        userInfo.setId(summonerDTO.id());
        userInfo.setName(summonerDTO.name());
        userInfo.setPuuid(summonerDTO.puuid());
        userInfo.setSummonerLevel(summonerDTO.summonerLevel());
        userInfo.setRank(getSummonerRank(summonerDTO.id()));

        return userInfo;
    }

    public LeagueEntryResponse getUserSolorank(String summonerName) {
        SummonerDTO summonerDTO = userInfoClient.getSummoner(summonerName);
        List<LeagueEntryDTO> summonerLeague = userInfoClient.getSummonerLeague(summonerDTO.id());
        LeagueEntryResponse solorank = new LeagueEntryResponse();

        for (LeagueEntryDTO league : summonerLeague) {
            if(league.queueType() == "RANKED_SOLO_5X5") {
            solorank.setQueueType(league.queueType());
            solorank.setRank(league.rank());
            solorank.setTier(league.tier());
            solorank.setLeaguePoints(league.leaguePoints());
            }
        }
        
        return solorank;
    }

    public LeagueEntryResponse getUserFlexrank(String summonerName) {
        SummonerDTO summonerDTO = userInfoClient.getSummoner(summonerName);
        List<LeagueEntryDTO> summonerLeague = userInfoClient.getSummonerLeague(summonerDTO.id());
        LeagueEntryResponse flexrank = new LeagueEntryResponse();

        for (LeagueEntryDTO league : summonerLeague) {
            if(league.queueType() == "RANKED_FLEX_5X5") {
            flexrank.setQueueType(league.queueType());
            flexrank.setRank(league.rank());
            flexrank.setTier(league.tier());
            flexrank.setLeaguePoints(league.leaguePoints());
            }
        }
        
        return flexrank;
    }
}
