package com.immersion.riot.userRating.api;

import com.immersion.riot.userRating.app.UserRatingService;
import com.immersion.riot.userRating.app.UserRatingViewService;
import com.immersion.riot.userRating.app.UserRatingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserRatingApi {

    private final UserRatingService userRatingService;
    private final UserRatingViewService userRatingViewService;

    @PostMapping("/rating")
    public ResponseEntity<String> rateUser(@RequestBody UserRatingRequest ratingRequest) {
        userRatingService.rateUser(ratingRequest);
        return ResponseEntity.ok("Rated Successfully.");
    }

    @GetMapping("/rating/{userId}")
    public ResponseEntity<Double> getAverageRating(@PathVariable Long userId) {
        double averageSkillRating = userRatingViewService.getAverageSkillRating(userId);
        double averageMannerRating = userRatingViewService.getAverageMannerRating(userId);
        double averageHonorRating = userRatingViewService.getAverageHonorRating(userId);
        double averageRating = (averageSkillRating+averageMannerRating+averageHonorRating)/3;
        return ResponseEntity.ok(averageRating);
    }
}
