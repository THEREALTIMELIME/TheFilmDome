package com.filmdome.movies.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "studio", schema = "movies")
public class Studio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "studio_name")
    private String name;

    @Column(name = "tmdb_id")
    private Integer tmdbId;

    @ManyToMany(mappedBy = "studios")
    @JsonIgnore
    private Set<Movie> movies = new HashSet<>();

}
