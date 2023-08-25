package com.immersion.riot.userinfo.app;

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
    private final UserRankService userRankService;
    private final IconImageUrlBuilderService iconImageUrlBuilderService;

    public UserInfoResponse getSummonerInfo(String summonerName) {
        SummonerDTO summonerDTO = userInfoClient.getSummoner(summonerName);
        UserInfoResponse userInfo = new UserInfoResponse();

        userInfo.setProfileImageUrl(iconImageUrlBuilderService.getProfileImageUrl(summonerDTO.profileIconId()));
        userInfo.setId(summonerDTO.id());
        userInfo.setName(summonerDTO.name());
        userInfo.setPuuid(summonerDTO.puuid());
        userInfo.setSummonerLevel(summonerDTO.summonerLevel());
//        userInfo.setRank(userRankService.getSummonerRank(summonerDTO.id()));
        userInfo.setSoloRank(userRankService.getUserSoloRank(summonerDTO.id()));
        userInfo.setFlexRank(userRankService.getUserFlexRank(summonerDTO.id()));

        return userInfo;
    }


}
