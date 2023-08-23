package com.immersion.riot.userRating.domain;

import lombok.Data;

@Data
public class UserRatingDTO {
    private String puuid;
    private Long raterUserId;
    private int skillRating;
    private int mannerRating;
    private int honorRating;
}
