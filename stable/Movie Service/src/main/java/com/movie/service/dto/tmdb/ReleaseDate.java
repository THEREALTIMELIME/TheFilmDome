package com.movie.service.dto.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.Data;

@Data
public class ReleaseDate {

    private String certification;

    @JsonProperty("release_date")
    private Date releaseDate;

    private Integer type;

}