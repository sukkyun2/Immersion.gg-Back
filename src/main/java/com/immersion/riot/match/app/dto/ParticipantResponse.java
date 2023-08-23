package com.immersion.riot.match.app.dto;

import com.immersion.riot.match.infra.dto.ParticipantDto;

public record ParticipantResponse(
        String championImageUrl,
        int championLevel,
        String summonerName,
        String teamPosition,
        int kill,
        int death,
        int assist,
        double kda,
        boolean win,
        int visionScore,
        int cs,
        String spellImageUrl1, //key
        String spellImageUrl2, //key
        String perkImageUrl1, //key
        String perkImageUrl2, //key
        String itemImageUrl1, //붙이면됨
        String itemImageUrl2,
        String itemImageUrl3,
        String itemImageUrl4,
        String itemImageUrl5,
        String itemImageUrl6
) {
    public static ParticipantResponse of(String championImageUrl, String summmonerName, int championLevel, String teamPosition, int kill, int death, int assist, double kda, boolean win, int visionScore, int cs, String spellImageUrl1, String spellImageUrl2, String perkImageUrl1, String perkImageUrl2, String itemImageUrl1, String itemImageUrl2, String itemImageUrl3, String itemImageUrl4, String itemImageUrl5, String itemImageUrl6) {
        return new ParticipantResponse(
                championImageUrl,
                championLevel,
                summmonerName,
                teamPosition,
                kill,
                death,
                assist,
                kda,
                win,
                visionScore,
                cs,
                spellImageUrl1,
                spellImageUrl2,
                perkImageUrl1,
                perkImageUrl2,
                itemImageUrl1,
                itemImageUrl2,
                itemImageUrl3,
                itemImageUrl4,
                itemImageUrl5,
                itemImageUrl6
        );
    }


}


