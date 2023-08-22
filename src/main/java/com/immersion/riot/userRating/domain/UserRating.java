package com.immersion.riot.userRating.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
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
    }

    public UserRating() {

    }
}
