package com.immersion.riot.match.app.service;

import com.immersion.riot.common.app.NoDataException;
import com.immersion.riot.match.infra.client.CdnClient;
import com.immersion.riot.match.infra.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImageUrlBuilderService {

    private final CdnClient cdnClient;

    @Value("${riot.versions}")
    private String VERSION;

    @Value("${riot.api.url.cdn}")
    private String CDN_URL;

    public String getSpellImageUrl(int spellKey) {
        SummonerCastQueryResponse summonerCastResponse = cdnClient.getSummonerCast(VERSION);
        SummonerCastDto summonerCast = summonerCastResponse.data().values().stream()
                .filter(summonerCastDto -> summonerCastDto.key() == spellKey)
                .findFirst()
                .orElseThrow(() -> new NoDataException("spellKey: " + spellKey + "에 해당하는 스펠이 없습니다."));

        return CDN_URL + VERSION + "/img/spell/"  + summonerCast.image().full();
    }

    public String getPerkImageUrl(int perkId) {
        List<SummonerPerksQueryResponse> summonerPerkResponse = cdnClient.getSummonerPerk(VERSION);

        SummonerPerksQueryResponse summonerPerk = summonerPerkResponse.stream()
                .filter(summonerPerksQueryResponse -> summonerPerksQueryResponse.id() == perkId)
                .findFirst()
                .orElseThrow(() -> new NoDataException("perkId: " + perkId + "에 해당하는 룬이 없습니다."));

        return CDN_URL + "img/" + summonerPerk.icon();
    }

    public String getChampionImageUrl(int championKey) {
        ChampionQueryResponse championQueryResponse = cdnClient.getChampion(VERSION);

        ChampionDto champion = championQueryResponse.data().values().stream()
                .filter(championDto -> championDto.key() == championKey)
                .findFirst()
                .orElseThrow(() -> new NoDataException("championKey: " + championKey  + "에 해당하는 챔피언이 없습니다."));

        return CDN_URL + VERSION + "/img/champion/" + champion.image().full();
    }

    public String getChampionImageUrlByName(String championName) {

        return CDN_URL + VERSION + "/img/champion/" + championName + ".png";
    }

    public String getItemImageUrl(int itemKey) {
        return CDN_URL + VERSION + "/img/item/" + itemKey + ".png";
    }
}
