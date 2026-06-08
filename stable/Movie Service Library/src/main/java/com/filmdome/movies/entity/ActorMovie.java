package com.filmdome.movies.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "actor_movie", schema = "movies")
public class ActorMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_movie_id")
    @JsonIgnore
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "fk_actor_id")
    private Actor actor;

    @Column(name = "cast_order")
    private Integer castOrder;

    @Column(name = "character_name")
    private String character;

}
