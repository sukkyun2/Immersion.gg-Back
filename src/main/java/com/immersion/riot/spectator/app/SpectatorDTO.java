package com.immersion.riot.spectator.app;


import com.immersion.riot.spectator.infra.Perks;
import com.immersion.riot.spectator.infra.SpectatorQueryResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SpectatorDTO {
    private String gameId;
    private int mapId;
    private String gameMode;
    private String gameType;
    private int gameQueueConfigId;
    private List<CurrentGameParticipant> participants;
    private String platformId;
    private String gameStartTime;
    private String gameLength;

    public void setParticipants(List<SpectatorQueryResponse.CurrentGameParticipant> participants) {
    }

    // Constructors, getters, setters
    @Data
    @NoArgsConstructor
    public static class CurrentGameParticipant {
        private int teamId;
        private int spell1Id;
        private int spell2Id;
        private int championId;
        private int profileIconId;
        private String summonerName;
        private boolean bot;
        private String summonerId;
        private Perks perks;


    }}
