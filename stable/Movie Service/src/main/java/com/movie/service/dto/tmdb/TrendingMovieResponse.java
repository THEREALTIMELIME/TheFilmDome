package com.movie.service.dto.tmdb;

import java.util.List;
import lombok.Data;

@Data
public class TrendingMovieResponse {

    private List<TmdbMovie> results;

}