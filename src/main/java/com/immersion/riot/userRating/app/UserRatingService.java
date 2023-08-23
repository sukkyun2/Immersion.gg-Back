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

    public void rateUser(UserRatingRequest ratingRequest) {
        UserRating userRating = new UserRating(
                ratingRequest.getRatedUserId(),
                ratingRequest.getRaterUserId(),
                ratingRequest.getSkillRating(),
                ratingRequest.getMannerRating(),
                ratingRequest.getHonorRating()
        );
        userRatingRepository.save(userRating);
    }


}
