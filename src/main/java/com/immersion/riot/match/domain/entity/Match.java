package com.immersion.riot.match.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
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

    private Match(String matchId, LocalDateTime gameStartTimestamp, long gameDuration, LocalDateTime gameEndTimestamp, List<Participant> participants, String winTeam) {
        this.matchId = matchId;
        this.gameStartTimestamp = gameStartTimestamp;
        this.gameDuration = gameDuration;
        this.gameEndTimestamp = gameEndTimestamp;
        this.participants = participants;
        this.winTeam = winTeam;
    }

    public static Match of(String matchId, LocalDateTime gameStartTimestamp, long gameDuration, LocalDateTime gameEndTimestamp, List<Participant> participants, String winTeam) {
        return new Match(
                matchId,
                gameStartTimestamp,
                gameDuration,
                gameEndTimestamp,
                participants,
                winTeam
        );
    }

}
