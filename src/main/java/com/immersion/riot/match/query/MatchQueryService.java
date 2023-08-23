package com.immersion.riot.match.query;

import com.immersion.riot.common.app.NoDataException;
import com.immersion.riot.match.app.dto.MatchDto;
import com.immersion.riot.match.domain.entity.Match;
import com.immersion.riot.match.domain.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MatchQueryService {

    private final MatchRepository matchRepository;

    public List<MatchDto> getMatchList(String puuid) {
        List<Match> matchList = matchRepository.getMatchListByPuuid(puuid);

        if (matchList.isEmpty()) {
            log.info("해당하는 소환사의 전적을 조회 할 수 없습니다 - puuid: {}", puuid);
            throw new NoDataException("no match history");
        }

        return matchList.stream()
                .map(MatchDto::from)
                .toList();
    }

}
