package com.filmdome.movies.repository;

import com.filmdome.movies.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface MoviesRepository extends JpaRepository<Movie, Integer> {

    Movie findById(int id);

    boolean existsByTmdbId(Integer tmdbId);

    List<Movie> findByTrending(int trending);

    List<Movie> findByNewest(int newest);

    List<Movie> findByNameContainingIgnoreCase(String name);

    List<Movie> findByDirectorContainingIgnoreCase(String director);

    List<Movie> findByPopularityGreaterThanOrderByPopularityDesc(Double popularity);

    List<Movie> findByReleaseDateBetweenOrderByReleaseDateDesc(Date startDate, Date endDate);

    @Query(value = """
        SELECT DISTINCT m.*
        FROM movie m
        LEFT JOIN actor_movie am ON am.fk_movie_id = m.id
        LEFT JOIN actor a ON a.id = am.fk_actor_id
        LEFT JOIN studio_movie sm ON sm.fk_movie_id = m.id
        LEFT JOIN studio s ON s.id = sm.fk_studio_id
        WHERE LOWER(m.movie_name) LIKE LOWER(CONCAT('%', :search, '%'))
           OR LOWER(a.actor_name) LIKE LOWER(CONCAT('%', :search, '%'))
           OR LOWER(s.studio_name) LIKE LOWER(CONCAT('%', :search, '%'))
        ORDER BY m.popularity DESC
        """, nativeQuery = true
    )
    List<Movie> searchEverything(@Param("search") String search);
}