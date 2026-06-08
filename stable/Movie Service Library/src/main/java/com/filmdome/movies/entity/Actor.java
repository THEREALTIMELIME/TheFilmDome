package com.filmdome.movies.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "actor", schema = "movies")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "imdb_id")
    private String imdbId;

    @Column(name = "tmdb_id")
    private Integer tmdbId;

    @OneToMany(mappedBy = "actor")
    @JsonIgnore
    private List<ActorMovie> movies = new ArrayList<>();

    @Column(name = "summary", columnDefinition = "TEXT")
    private String summary;

    @Column(name = "actor_name")
    private String actorName;

    private Date birthday;

    private String gender;

    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @Column(name = "profile_path")
    private String profilePath;

}
