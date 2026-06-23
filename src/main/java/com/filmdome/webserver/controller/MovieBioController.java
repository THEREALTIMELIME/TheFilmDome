package com.filmdome.webserver.controller;

import com.filmdome.movies.repository.ActorRepository;
import com.filmdome.movies.repository.MoviesRepository;
import com.filmdome.movies.entity.*;
import com.filmdome.webserver.util.ActorUtil;
import com.filmdome.webserver.util.MovieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MovieBioController {


    private final MoviesRepository moviesRepository;

    private final ActorRepository actorRepository;

    @Autowired
    public MovieBioController(MoviesRepository moviesRepository, ActorRepository actorRepository) {
        this.moviesRepository = moviesRepository;
        this.actorRepository = actorRepository;
    }

    @RequestMapping(value = "/imageSelection", method = RequestMethod.GET)
    public String imageSelection(@RequestParam("id") int id, Model model) {
        model.addAttribute("movie", MovieUtil.convertMovie(moviesRepository.findById(id)));
        return "movie-bio";
    }

    @RequestMapping(value = "/actorSelection", method = RequestMethod.GET)
    public String actorSelection(@RequestParam("id") int id, Model model) {

        Actor actor = actorRepository.findById(id);
        model.addAttribute("actor", ActorUtil.convertTo(actorRepository.findById(id)));

        return "actor-bio";
    }
}