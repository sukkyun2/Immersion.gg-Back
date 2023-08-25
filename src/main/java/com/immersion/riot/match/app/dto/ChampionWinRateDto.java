package com.immersion.riot.match.app.dto;

import lombok.Data;

@Data
public class ChampionWinRateDto {
    private int totalMatches;
    private int wins;

    public ChampionWinRateDto incrementTotalMatches() {
        totalMatches++;
        return this;
    }

    public void incrementWins(int count) {
        wins += count;
    }

    public double getWinRate() {
        if (totalMatches == 0) {
            return 0.0;
        }
        return (double) wins / totalMatches * 100;
    }
}
