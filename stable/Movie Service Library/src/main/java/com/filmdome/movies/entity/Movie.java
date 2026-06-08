package com.filmdome.movies.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "movie", schema = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tmdb_id")
    private Integer tmdbId;

    @Column(name = "movie_name")
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "rated")
    private String rating;

    @Column(name = "director")
    private String director;

    @Column(name = "run_time")
    private Integer runTime;

    @Column(name = "poster")
    private String poster;

    @Column(name = "trailer")
    private String trailer;

    @Column(name = "trending")
    private int trending;

    @Column(name = "newest")
    private int newest;

    @Column(name = "release_date")
    private Date releaseDate;

    private Integer budget;

    private Double popularity;

    private Long revenue;

    @Column(name = "vote_average")
    private Double voteAverage;

    @Column(name = "vote_count")
    private Double voteCount;


    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    @OrderBy("castOrder ASC")
    private List<ActorMovie> actors = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "studio_movie",
            joinColumns = @JoinColumn(name = "fk_movie_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_studio_id")
    )
    private Set<Studio> studios = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "genre_movie",
            joinColumns = @JoinColumn(name = "fk_movie_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_genre_id")
    )
    private Set<Genre> genres = new HashSet<>();

    public Movie() {

    }
}