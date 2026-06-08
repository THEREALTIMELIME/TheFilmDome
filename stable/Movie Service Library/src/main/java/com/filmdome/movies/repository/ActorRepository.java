package com.filmdome.movies.repository;

import com.filmdome.movies.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
    Actor findById(int id);
    Actor findByTmdbId(Integer tmdbId);
    boolean existsByTmdbId(Integer tmdbId);
}
