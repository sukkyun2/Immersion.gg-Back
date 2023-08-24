package com.immersion.riot.userRating.api;

import com.immersion.riot.userRating.app.UserRatingService;
import com.immersion.riot.userRating.app.UserRatingViewService;
import com.immersion.riot.userRating.app.UserRatingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserRatingApi {

    private final UserRatingService userRatingService;
    private final UserRatingViewService userRatingViewService;

    @PostMapping("/rate")
    public ResponseEntity<String> rateUser(@RequestBody UserRatingRequest ratingRequest) {
        userRatingService.rateUser(ratingRequest);
        return ResponseEntity.ok("Rated Successfully.");
    }

    @GetMapping("/rating/{userId}")
    public ResponseEntity<List> getAverageRating(@PathVariable Long userId) {

        List<Double> userRatings = userRatingViewService.getUserRating(userId);
        return ResponseEntity.ok(userRatings);
    }

    @GetMapping("/ingame/rating/{userId}")
    public ResponseEntity<Double> getInGameRating(@PathVariable Long userId) {
        double InGameRating = userRatingViewService.getInGameRatings(userId);
        return ResponseEntity.ok(InGameRating);
    }
}
