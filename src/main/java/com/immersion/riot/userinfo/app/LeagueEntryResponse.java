package com.immersion.riot.userinfo.app;

import lombok.Data;

@Data
public class LeagueEntryResponse {
    String queueType;
    String tier;
    String rank;
    int leaguePoints;
}
