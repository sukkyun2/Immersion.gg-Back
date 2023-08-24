package com.immersion.riot.userRating.app;

import com.immersion.riot.userRating.domain.UserRating;
import com.immersion.riot.userRating.domain.UserRatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRatingViewService {

    private final UserRatingRepository userRatingRepository;

    public double getAverageSkillRating(Long userId) {
        List<UserRating> ratings = userRatingRepository.findByRatedUserId(userId);

        if (ratings.isEmpty()) {
            return 0.0;
        }

        double totalSkillRating = 0;

        for (UserRating rating : ratings) {
            totalSkillRating += rating.getSkillRating();
        }

        return totalSkillRating / ratings.size();
    }

    public double getAverageMannerRating(Long userId) {
        List<UserRating> ratings = userRatingRepository.findByRatedUserId(userId);

        if (ratings.isEmpty()) {
            return 0.0;
        }

        double totalMannerRating = 0;

        for (UserRating rating : ratings) {
            totalMannerRating += rating.getMannerRating();
        }

        return totalMannerRating / ratings.size();
    }

    public double getAverageHonorRating(Long userId) {
        List<UserRating> ratings = userRatingRepository.findByRatedUserId(userId);

        if (ratings.isEmpty()) {
            return 0.0;
        }

        double totalHonorRating = 0;

        for (UserRating rating : ratings) {
            totalHonorRating += rating.getHonorRating();
        }

        return totalHonorRating / ratings.size();
    }

    public List<Double> getUserRating(Long userId) {
        List<Double> userRating;

        userRating.add(getSkillRating(userId));
        userRating.add(getAverageMannerRating(userId));
        userRating.add(getAverageHonorRating(userId));

        return userRating;
    }

    public double getInGameRatings(Long userId) {
        return (getAverageSkillRating(userId)+getAverageMannerRating(userId)+getAverageHonorRating(userId))/3;
    }
}
