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
        LeagueEntryResponse solorank = new LeagueEntryResponse();

        return solorank;
    }

    public LeagueEntryResponse getUserFlexrank(String summonerName) {
        SummonerDTO summonerDTO = userInfoClient.getSummoner(summonerName);
        LeagueEntryResponse flexrank = new LeagueEntryResponse();

        return flexrank;
    }
}
