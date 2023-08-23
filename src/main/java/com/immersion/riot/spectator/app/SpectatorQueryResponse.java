package com.immersion.riot.spectator.app;

import java.util.List;

public class SpectatorQueryResponse {
    private int mapId;
    private long gameLength;
    private String gameMode;
    private List<CurrentGameParticipant> participants;

    // Constructors, getters, setters

    public static class CurrentGameParticipant {
        private int championId;
        private int profileIconId;
        private boolean bot;
        private int teamId;
        private String summonerName;
        private String summonerId;
        private int spell1Id;
        private int spell2Id;
        private Perks perks;

        // Constructors, getters, setters

        public static class Perks {
            private List<Integer> perkIds;
            private int perkStyle;
            private int perkSubStyle;

            // Constructors, getters, setters
        }
    }
}
