package com.immersion.riot.userinfo.app;

import com.immersion.riot.userRating.app.UserRatingViewService;
import com.immersion.riot.userinfo.infra.dto.SummonerDTO;
import com.immersion.riot.userinfo.infra.client.UserInfoClient;
import com.immersion.riot.match.app.service.ImageUrlBuilderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserInfoService {

    private final UserInfoClient userInfoClient;
    private final UserRatingViewService userRatingViewService;
    private final ImageUrlBuilderService iconImageUrlBuilderService;
    private final UserRankService userRankService;

    public UserInfoResponse getSummonerInfo(String summonerName) {
        SummonerDTO summonerDTO = userInfoClient.getSummoner(summonerName);
        UserInfoResponse userInfo = new UserInfoResponse();

        LeagueEntryResponse userSoloRank = userRankService.getUserSoloRank(summonerName);
        LeagueEntryResponse userFlexRank = userRankService.getUserFlexRank(summonerName);


        userInfo.setTiers(List.of(userSoloRank, userFlexRank));
        userInfo.setProfileImageUrl(iconImageUrlBuilderService.getProfileImageUrl(summonerDTO.profileIconId()));
        userInfo.setId(summonerDTO.id());
        userInfo.setName(summonerDTO.name());
        userInfo.setPuuid(summonerDTO.puuid());
        userInfo.setSummonerLevel(summonerDTO.summonerLevel());
        userInfo.setUserRatingAverage(userRatingViewService.getUserRatingAverage(summonerDTO.puuid()));

        return userInfo;
    }


}
