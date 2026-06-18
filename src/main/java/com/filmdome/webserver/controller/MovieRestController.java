package com.filmdome.webserver.controller;

import com.filmdome.movies.repository.MoviesRepository;
import com.filmdome.webserver.util.MovieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.filmdome.webserver.dto.MovieSearchDto;
import java.util.*;

@RestController
@RequestMapping("/api/movies")
public class MovieRestController {

    private MoviesRepository moviesRepository;

    @Autowired
    public MovieRestController(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    @GetMapping("/searchMovie")
    public List<MovieSearchDto> searchMovie(@RequestParam String title) {

        return MovieUtil.convertTo(moviesRepository.searchEverything(title));
    }
}
