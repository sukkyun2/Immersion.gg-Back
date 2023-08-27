package com.immersion.riot.match.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@IdClass(GptAnswerId.class)
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class GptAnswer {

    @Id
    private String puuid;

    @Id
    private String championName;

    @Column(length = 10000)
    String content;

    public void updateAnswer(String newAnswer) {
        content = newAnswer;
    }
}
