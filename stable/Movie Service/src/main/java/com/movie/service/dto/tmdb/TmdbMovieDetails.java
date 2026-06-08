package com.movie.service.dto.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TmdbMovieDetails {

    private int id;

    private String title;

    private String overview;

    private int runtime;

    @JsonProperty("credits")
    private TmdbCredits credits;

    @JsonProperty("videos")
    private TmdbVideosResponse videos;

    @JsonProperty("poster_path")
    private String posterPath;

    @JsonProperty("production_companies")
    private List<ProductionCompany> productionCompanies;

    @JsonProperty("release_dates")
    private ReleaseDatesResponse releaseDates;

    @JsonProperty("release_date")
    private Date releaseDate;

    private Integer budget;

    private List<TmdbGenre> genres;

    private Double popularity;

    private Long revenue;

    @JsonProperty("vote_average")
    private Double voteAverage;

    @JsonProperty("vote_count")
    private Integer voteCount;
}