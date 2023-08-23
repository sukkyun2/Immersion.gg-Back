package com.immersion.riot.userRating.app;

import com.immersion.riot.userRating.domain.UserRating;
import lombok.Getter;

@Getter
public class UserRatingRequest {
    private Long ratedUserId;
    private Long raterUserId;
    private int skillRating;
    private int mannerRating;
    private int honorRating;

    public UserRating toEntity() {
        return UserRating.builder()
                .ratedUserId(ratedUserId)
                .raterUserId(raterUserId)
                .skillRating(skillRating)
                .mannerRating(mannerRating)
                .honorRating(honorRating)
                .build();
    }
}
