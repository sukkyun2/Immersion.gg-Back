package com.immersion.riot.userRating.app;

import com.immersion.riot.userRating.domain.UserRating;
import lombok.Getter;

@Getter
public class UserRatingRequest {
    private String puuid;
    private Long raterUserId;
    private int skillRating;
    private int mannerRating;
    private int honorRating;

    public UserRating toEntity() {
        return UserRating.builder()
                .puuid(puuid)
                .raterUserId(raterUserId)
                .skillRating(skillRating)
                .mannerRating(mannerRating)
                .honorRating(honorRating)
                .build();
    }
}