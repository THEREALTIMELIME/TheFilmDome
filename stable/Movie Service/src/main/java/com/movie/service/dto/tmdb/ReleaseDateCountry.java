package com.movie.service.dto.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class ReleaseDateCountry {

    @JsonProperty("iso_3166_1")
    private String countryCode;

    @JsonProperty("release_dates")
    private List<ReleaseDate> releaseDates;

}