package com.immersion.riot.userRating.domain;

import lombok.Data;

@Data
public class UserRatingDTO {
    private Long ratedUserId;
    private Long raterUserId;
    private int skillRating;
    private int mannerRating;
    private int honorRating;
}
