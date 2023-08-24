package com.immersion.riot.match.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "GAME_MATCH")
@ToString
@AllArgsConstructor(staticName = "of")
public class Match {

    @Id
    private String matchId;

    private LocalDateTime gameStartTime;

    private long gameDuration;

    private LocalDateTime gameEndTime;

    @ToString.Exclude
    @OneToMany(mappedBy = "matchId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Participant> participants = new ArrayList<>();

    private String winTeam;

}
