package com.immersion.riot.match.query;

import com.immersion.riot.match.domain.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MatchQueryService {

    private final MatchRepository matchRepository;



}
