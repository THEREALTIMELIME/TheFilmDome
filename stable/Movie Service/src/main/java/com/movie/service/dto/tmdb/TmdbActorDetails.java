package com.movie.service.dto.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.Data;

@Data
public class TmdbActorDetails {

    @JsonProperty("id")
    private Integer tmdbId;

    @JsonProperty("imdb_id")
    private String imdbId;

    private String name;

    private String biography;

    private Date birthday;

    private String gender;

    @JsonProperty("place_of_birth")
    private String placeOfBirth;

    @JsonProperty("profile_path")
    private String profilePath;

    private String character;

    @JsonProperty("original_name")
    private String originalName;

}
