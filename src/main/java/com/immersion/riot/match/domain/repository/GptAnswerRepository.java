package com.immersion.riot.match.domain.repository;

import com.immersion.riot.match.domain.entity.GptAnswer;
import com.immersion.riot.match.domain.entity.GptAnswerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GptAnswerRepository extends JpaRepository<GptAnswer, GptAnswerId> {
}
