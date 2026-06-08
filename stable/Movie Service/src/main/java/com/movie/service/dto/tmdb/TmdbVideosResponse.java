package com.movie.service.dto.tmdb;

import java.util.List;
import lombok.Data;

@Data
public class TmdbVideosResponse {

    private List<TmdbVideo> results;

}