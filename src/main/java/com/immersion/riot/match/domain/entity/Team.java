package com.immersion.riot.match.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(staticName = "of")
@IdClass(TeamId.class)
@Getter
@Table(indexes = {
        @Index(columnList = "matchId"),
        @Index(columnList = "teamId"),
})
public class Team {

    @Id
    private String matchId;

    @Id
    private String teamId;

    private int baronKill;

    private int dragonKill;

}
