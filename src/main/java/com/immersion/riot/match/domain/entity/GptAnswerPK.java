package com.immersion.riot.match.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GptAnswerPK implements Serializable {

    private String puuid;

    private String championName;

}
