package com.movie.service.config;

import com.movie.service.service.TmdbService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final TmdbService tmdbService;

    @Override
    public void run(String... args) {

        System.out.println("IMPORTING TMDB DATA...");

        tmdbService.getTrendingMovies();

        System.out.println("IMPORT COMPLETE");
    }
}