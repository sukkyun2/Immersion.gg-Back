package com.immersion.riot.match.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@IdClass(ParticipantId.class)
@Getter
@ToString
public class Participant {

    @Id
    private String matchId;

    @Id
    private String puuid;

    private int participantId;

    private int kills;

    private int deaths;

    private int assists;

    private int item0;

    private int item1;

    private int item2;

    private int item3;

    private int item4;

    private int item5;

    private int item6;

    private int champLevel;

    private int championId;

    private String championName;

    private int totalMinionsKilled;

    private int summoner1Id;

    private int summoner2Id;

    private int primaryPerk;

    private int subPerk;

    private String summonerId;

    private String summonerName;

    private int teamId;

    private String teamPosition;

    private int totalDamageDealtToChampions;

    private int totalDamageTaken;

    private int visionScore;

    private boolean win;

    private Participant(String matchId, int participantId, int kills, int deaths, int assists, int item0,
                        int item1, int item2, int item3, int item4, int item5, int item6, int champLevel,
                        int championId, String championName, String puuid, String summonerId, String summonerName,
                        int teamId, String teamPosition, int totalDamageDealtToChampions, int totalDamageTaken,
                        int visionScore, boolean win, int summoner1Id, int summoner2Id, int primaryPerk, int subPerk,
                        int totalMinionsKilled) {
        this.matchId = matchId;
        this.participantId = participantId;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.item0 = item0;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.item4 = item4;
        this.item5 = item5;
        this.item6 = item6;
        this.champLevel = champLevel;
        this.championId = championId;
        this.championName = championName;
        this.puuid = puuid;
        this.summonerId = summonerId;
        this.summonerName = summonerName;
        this.teamId = teamId;
        this.teamPosition = teamPosition;
        this.totalDamageDealtToChampions = totalDamageDealtToChampions;
        this.totalDamageTaken = totalDamageTaken;
        this.visionScore = visionScore;
        this.win = win;
        this.summoner1Id = summoner1Id;
        this.summoner2Id = summoner2Id;
        this.primaryPerk = primaryPerk;
        this.subPerk = subPerk;
        this.totalMinionsKilled = totalMinionsKilled;
    }

    public static Participant of(String matchId, int participantId, int kills, int deaths, int assists, int item0,
                                 int item1, int item2, int item3, int item4, int item5, int item6, int champLevel,
                                 int championId, String championName, String puuid, String summonerId, String summonerName,
                                 int teamId, String teamPosition, int totalDamageDealtToChampions, int totalDamageTaken,
                                 int visionScore, boolean win, int summoner1Id, int summoner2Id, int primaryPerk, int subPerk,
                                 int totalMinionsKilled) {
        return new Participant(
                matchId,
                participantId,
                kills,
                deaths,
                assists,
                item0,
                item1,
                item2,
                item3,
                item4,
                item5,
                item6,
                champLevel,
                championId,
                championName,
                puuid,
                summonerId,
                summonerName,
                teamId,
                teamPosition,
                totalDamageDealtToChampions,
                totalDamageTaken,
                visionScore,
                win,
                summoner1Id,
                summoner2Id,
                primaryPerk,
                subPerk,
                totalMinionsKilled
        );
    }
}
