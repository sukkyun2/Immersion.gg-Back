package com.immersion.riot.userinfo.app;

import lombok.Data;

@Data
public class UserInfoResponse {
    private String profileImageUrl;
    private String name;
    private String id;
    private String puuid;
    private long summonerLevel;
    private double userRatingAverage;
}
