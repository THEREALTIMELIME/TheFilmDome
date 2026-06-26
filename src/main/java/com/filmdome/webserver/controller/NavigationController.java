package com.filmdome.webserver.controller;

import com.filmdome.movies.repository.MoviesRepository;
import com.filmdome.webserver.repository.NewsRepository;
import com.filmdome.webserver.util.MovieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Controller
public class NavigationController {

    private final NewsRepository newsRepository;
    private final MoviesRepository moviesRepository;

    Date end = new Date();
    Date start = Date.from(Instant.now().minus(30, ChronoUnit.DAYS));

    @Autowired
    public NavigationController(NewsRepository newsRepository, MoviesRepository moviesRepository) {
        this.newsRepository = newsRepository;
        this.moviesRepository = moviesRepository;
    }

    @GetMapping("/displayHomePage")
    public String displayHomePage(Model theModel) {
        theModel.addAttribute("trendingMovies", moviesRepository.findByPopularityGreaterThanOrderByPopularityDesc(50.0));
        theModel.addAttribute("newestMovies", moviesRepository.findByReleaseDateBetweenOrderByReleaseDateDesc(start, end));
        return "home-page";
    }

    @GetMapping("/displaySearchPage")
    public String displaySearchPage(Model theModel) {
        theModel.addAttribute("trendingMovies", moviesRepository.findByPopularityGreaterThanOrderByPopularityDesc(50.0));
        theModel.addAttribute("newestMovies", moviesRepository.findByReleaseDateBetweenOrderByReleaseDateDesc(start, end));
        return "searched-page";
    }

    @GetMapping("/newsPage")
    public String newsPage(Model theModel){
        theModel.addAttribute("allNews", newsRepository.findAll());
        return "news";
    }
}