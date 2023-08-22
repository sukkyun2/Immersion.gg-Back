package com.immersion.riot.userRating.app;

import com.immersion.riot.userRating.domain.UserRatingDTO;
import com.immersion.riot.userRating.domain.UserRating;
import com.immersion.riot.userRating.domain.UserRatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRatingService {

    private final UserRatingRepository userRatingRepository;

    public void rateUser(UserRatingDTO ratingDTO) {
        UserRating userRating = new UserRating(
                ratingDTO.getRatedUserId(),
                ratingDTO.getRaterUserId(),
                ratingDTO.getSkillRating(),
                ratingDTO.getMannerRating(),
                ratingDTO.getHonorRating()
        );
        userRatingRepository.save(userRating);
    }

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

    public List<UserRating> getUserRatings(Long userId) {
        return userRatingRepository.findByRatedUserId(userId);
    }
}
