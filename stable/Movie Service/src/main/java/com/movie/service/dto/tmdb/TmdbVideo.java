package com.movie.service.dto.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.Data;

@Data
public class TmdbVideo {

    private String key;

    private String site;

    private String type;

    @JsonProperty("published_at")
    private Date publishedDate;

}