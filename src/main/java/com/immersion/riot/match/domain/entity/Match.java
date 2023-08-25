package com.immersion.riot.match.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(staticName = "of")
@Getter
@Table(name = "GAME_MATCH")
public class Match {

    @Id
    private String matchId;

    private LocalDateTime gameStartTime;

    private long gameDuration;

    private int queueId;

    private LocalDateTime gameEndTime;

    @OneToMany(mappedBy = "matchId", fetch = FetchType.LAZY)
    private List<Participant> participants = new ArrayList<>();

    private String winTeam;
}
