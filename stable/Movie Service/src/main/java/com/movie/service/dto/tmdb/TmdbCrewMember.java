package com.movie.service.dto.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TmdbCrewMember {


    @JsonProperty("id")
    private Integer tmdbId;

    private String name;

    private String job;

    @Override
    public String toString() {
        return "Id: " + this.tmdbId + " , Name: " + this.name + " , Job: " + this.job;
    }
}
