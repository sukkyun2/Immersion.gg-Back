package com.immersion.riot.userRating.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long ratedUserId;
    private Long raterUserId;
    private int skillRating;
    private int mannerRating;
    private int honorRating;

    public UserRating(Long ratedUserId, Long raterUserId, int skillRating, int mannerRating, int honorRating) {
        this.ratedUserId = ratedUserId;
        this.raterUserId = raterUserId;
        this.skillRating = skillRating;
        this.mannerRating = mannerRating;
        this.honorRating = honorRating;
    }

}
