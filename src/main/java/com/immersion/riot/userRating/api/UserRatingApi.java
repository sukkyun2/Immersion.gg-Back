package com.immersion.riot.userRating.api;

import com.immersion.riot.userRating.app.UserRatingService;
import com.immersion.riot.userRating.domain.UserRatingDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserRatingApi {

    private final UserRatingService userRatingService;

    @PostMapping("/rating")
    public ResponseEntity<String> rateUser(@RequestBody UserRatingDTO ratingDTO) {
        userRatingService.rateUser(ratingDTO);
        return ResponseEntity.ok("Rated Successfully.");
    }

    @GetMapping("/rating/{userId}")
    public ResponseEntity<Double> getAverageRating(@PathVariable Long userId) {
        double averageSkillRating = userRatingService.getAverageSkillRating(userId);
        double averageMannerRating = userRatingService.getAverageMannerRating(userId);
        double averageHonorRating = userRatingService.getAverageHonorRating(userId);
        double averageRating = (averageSkillRating+averageMannerRating+averageHonorRating)/3;
        return ResponseEntity.ok(averageRating);
    }
}
