package com.filmdome.movies.repository;
import com.filmdome.movies.entity.Studio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudioRepository extends JpaRepository<Studio, Integer> {

    boolean existsByTmdbId(Integer tmdbId);

    Studio findByTmdbId(Integer tmdbId);

}