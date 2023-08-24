package com.immersion.riot.spectator.app;

import com.immersion.riot.spectator.infra.BannedChampion;
import com.immersion.riot.spectator.infra.Perks;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@NoArgsConstructor
public class SpectatorQueryResponse {
    private String gameId;
    private int mapId;
    private String gameMode;
    private String gameType;
    private int gameQueueConfigId;
    private List<CurrentGameParticipant> participants;
    private CurrentGameParticipant.Observers observers;
    private String platformId;
    private List<BannedChampion> bannedChampions;
    private String gameStartTime;
    private String gameLength;

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
        private List<Integer> gameCustomizationObjects;
        private Perks perks;

        @Data
        @NoArgsConstructor
        public static class Observers {
            private String encryptionKey;
        }

        @Data
        @NoArgsConstructor
        public static class BannedChampion {
            private int championId;
            private int teamId;
            private int pickTurn;
            
        }
    }}
