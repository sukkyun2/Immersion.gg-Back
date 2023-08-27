package com.immersion.riot.match.domain.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class TeamId implements Serializable {
    private String matchId;
    private String teamId;
}
