package com.immersion.riot.match.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@AllArgsConstructor(staticName = "of")
public class Match {

    @Id
    private String matchId;

    private LocalDateTime gameStartTimestamp;

    private long gameDuration;

    private LocalDateTime gameEndTimestamp;

    @ToString.Exclude
    @OneToMany(mappedBy = "matchId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Participant> participants = new ArrayList<>();

    private String winTeam;

}
