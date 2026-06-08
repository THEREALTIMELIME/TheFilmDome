package com.movie.service.dto.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TmdbCastMember {

    private String name;

    @JsonProperty("id")
    private Integer actorCreditId;

    @JsonProperty("known_for_department")
    private String knownFor;

    private String character;

    private Integer order;

}

