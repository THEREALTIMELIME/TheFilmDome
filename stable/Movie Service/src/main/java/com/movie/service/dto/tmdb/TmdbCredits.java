package com.movie.service.dto.tmdb;

import java.util.List;
import lombok.Data;

@Data
public class TmdbCredits {

    private List<TmdbCastMember> cast;

    private List<TmdbCrewMember> crew;

}