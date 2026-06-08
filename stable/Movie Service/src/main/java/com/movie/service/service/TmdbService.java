package com.movie.service.service;

import com.filmdome.movies.repository.*;
import com.filmdome.movies.entity.*;
import com.movie.service.dto.tmdb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@Service
public class TmdbService {

    private final WebClient webClient;
    @Autowired
    private StudioRepository studioRepository;
    @Autowired
    private MoviesRepository moviesRepository;
    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Value("${tmdb.api.key}")
    private String apiKey;

    public TmdbService(WebClient webClient) {
        this.webClient = webClient;
    }


    private Actor getActorDetails(int actorId) {

        TmdbActorDetails actor = webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/person/{id}")
                        .queryParam("api_key", apiKey)
                        .build(actorId))
                .retrieve()
                .bodyToMono(TmdbActorDetails.class)
                .block();

        System.out.println("Actor INFO: " + actor);

        {
            Actor actorBio;
            if (!actorRepository.existsByTmdbId(actor.getTmdbId())) {

                if (actor.getName() == null) {
                    return null;
                }

                String abc = "budgetz";
                String value = actor.getName();
                if (actor.getName().equals(abc)) {
                    System.out.println("HHHHH");
                }

                if (value.equals(abc)) {
                    System.out.println("HHHHH");
                }

                if (value.equals("budgetz")) {
                    System.out.println("HHHHH");
                    return null;
                }

                String characterName = actor.getCharacter();
                String originalName = actor.getOriginalName();

                if (abc.equals(characterName)) {
                    System.out.println("HHHHH");
                }

                if (abc.equals(originalName)) {
                    System.out.println("HHHHH");
                }

                actorBio = new Actor();

                actorBio.setImdbId(actor.getImdbId());
                actorBio.setTmdbId(actor.getTmdbId());
                actorBio.setSummary(actor.getBiography());
                actorBio.setActorName(actor.getName());
                actorBio.setBirthday(actor.getBirthday());
                actorBio.setGender(actor.getGender());
                actorBio.setPlaceOfBirth(actor.getPlaceOfBirth());
                actorBio.setProfilePath(actor.getProfilePath());
                actorRepository.save(actorBio);

            } else {
                actorBio = actorRepository.findByTmdbId(actor.getTmdbId());
            }
            return actorBio;
        }
    }

    private void getMovieDetails(int movieId) {

        TmdbMovieDetails movie = webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/movie/{id}")
                        .queryParam("api_key", apiKey)
                        .queryParam("append_to_response",
                                "videos,credits,release_dates")
                        .build(movieId))
                .retrieve()
                .bodyToMono(TmdbMovieDetails.class)
                .block();

        if (movie != null) {

            if (!moviesRepository.existsByTmdbId(movie.getId())) {
                TmdbCrewMember director = new TmdbCrewMember();


                System.out.println("===== MOVIE DETAILS =====");
                System.out.println("Processing movie: " + movie);

                Set<Studio> studios = new HashSet<Studio>();
                if (movie.getProductionCompanies() != null) {

                    for (ProductionCompany company : movie.getProductionCompanies()) {
                        Studio studio = null;

                        if (!studioRepository.existsByTmdbId(company.getId())) {
                            studio = new Studio();
                            studio.setName(company.getName());
                            studio.setTmdbId(company.getId());
                            studioRepository.save(studio);
                        } else {
                            studio = studioRepository.findByTmdbId(company.getId());
                        }
                        studios.add(studio);
                    }
                }

                Set<Genre> genres = new HashSet<Genre>();
                if (movie.getGenres() != null) {

                    for (TmdbGenre tmdbGenre : movie.getGenres()) {
                        Genre genre = null;

                        if (!genreRepository.existsByTmdbId(tmdbGenre.getId())) {
                            genre = new Genre();
                            genre.setTmdbId(tmdbGenre.getId());
                            genre.setGenreName(tmdbGenre.getName());
                            genreRepository.save(genre);
                        } else {
                            genre = genreRepository.findByTmdbId(tmdbGenre.getId());
                        }
                        genres.add(genre);
                    }
                }

                TmdbVideo videoToUse = null;
                System.out.println("Trailer:");

                if (movie.getVideos() != null && movie.getVideos().getResults() != null) {
                    for (TmdbVideo video : movie.getVideos().getResults()) {
                        if ("YouTube".equals(video.getSite()) && "Trailer".equals(video.getType())) {
                            if (videoToUse == null) {
                                videoToUse = video;
                            } else {
                                if (videoToUse.getPublishedDate().after(video.getPublishedDate())) {
                                    videoToUse = video;
                                }
                            }
                        }
                    }
                }

                System.out.println("Main Cast:");
                List<ActorMovie> actors = new ArrayList<>();
                if (movie.getCredits() != null) {
                    if (movie.getCredits().getCast() != null) {
                        for (TmdbCastMember actor : movie.getCredits().getCast()) {

                            if ("Acting".equals(actor.getKnownFor())) {

                                ActorMovie actorMovie = new ActorMovie();
                                actorMovie.setCastOrder(actor.getOrder());
                                actorMovie.setActor(getActorDetails(actor.getActorCreditId()));
                                actorMovie.setCharacter(actor.getCharacter());

                                actors.add(actorMovie);
                            }
                        }
                    }

                    if (movie.getCredits().getCrew() != null) {
                        for (TmdbCrewMember crew : movie.getCredits().getCrew()) {

                            if ("Director".equals(crew.getJob())) {

                                director.setName(crew.getName());
                                System.out.println(crew.toString());
                                break;

                            }
                        }
                    }
                }

                String ageRating = "NR";

                if (movie.getReleaseDates() != null && movie.getReleaseDates().getResults() != null) {
                    for (CountryRelease country : movie.getReleaseDates().getResults()) {
                        if ("US".equals(country.getCountryCode())) {
                            for (ReleaseDate item : country.getReleaseDates()) {

                                if (item.getCertification() != null &&
                                        !item.getCertification().isEmpty()){
                                    ageRating = item.getCertification();
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }

                System.out.println("Age Rating: " + ageRating);

                Movie movieBio = new Movie();
                movieBio.setName(movie.getTitle());
                movieBio.setDirector(director.getName());
                movieBio.setDescription(movie.getOverview());
                movieBio.setRunTime(movie.getRuntime());
                movieBio.setRating(ageRating);
                movieBio.setPoster(movie.getPosterPath());
                movieBio.setTmdbId(movie.getId());
                movieBio.setStudios(studios);
                movieBio.setReleaseDate(movie.getReleaseDate());
                movieBio.setBudget(movie.getBudget());
                movieBio.setGenres(genres);
                movieBio.setPopularity(movie.getPopularity());
                movieBio.setRevenue(movie.getRevenue());
                movieBio.setVoteAverage(movie.getVoteAverage());
                movieBio.setVoteCount(Double.valueOf(movie.getVoteCount()));

                if (videoToUse != null) {
                    movieBio.setTrailer(videoToUse.getKey());
                }

                for (ActorMovie actorMovie : actors) {
                    actorMovie.setMovie(movieBio);
                }

                movieBio.setActors(actors);
                moviesRepository.save(movieBio);

                System.out.println("==============================");
            }
        }
    }

    public void getTrendingMovies() {

        TrendingMovieResponse response = webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/trending/movie/week")
                        .queryParam("api_key", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(TrendingMovieResponse.class)
                .block();

        System.out.println("===== TRENDING MOVIES =====");

        if (response != null && response.getResults() != null) {

            for (TmdbMovie movie : response.getResults()) {

                getMovieDetails(movie.getId());

                System.out.println("----------------------------------");
            }
        }
    }

}