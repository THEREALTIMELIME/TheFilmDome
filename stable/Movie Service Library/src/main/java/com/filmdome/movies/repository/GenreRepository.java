package com.filmdome.movies.repository;
import com.filmdome.movies.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

    boolean existsByTmdbId(Integer tmdbId);

    Genre findByTmdbId(Integer tmdbId);

}