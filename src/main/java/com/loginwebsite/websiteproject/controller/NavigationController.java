package com.loginwebsite.websiteproject.controller;

import com.filmdome.movies.repository.MoviesRepository;
import com.filmdome.movies.entity.*;
import com.loginwebsite.websiteproject.repository.NewsRepository;
import com.loginwebsite.websiteproject.util.ActorUtil;
import com.loginwebsite.websiteproject.util.MovieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

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

    @GetMapping("/homePage1")
    public String homePage(Model theModel) {
        theModel.addAttribute("trendingMovies", moviesRepository.findByPopularityGreaterThanOrderByPopularityDesc(50.0));
        theModel.addAttribute("newestMovies", moviesRepository.findByReleaseDateBetweenOrderByReleaseDateDesc(start, end));
        return "home-page";
    }

    @GetMapping("/searchPage")
    public String home2Page(Model theModel) {
        theModel.addAttribute("trendingMovies", moviesRepository.findByPopularityGreaterThanOrderByPopularityDesc(50.0));
        theModel.addAttribute("newestMovies", moviesRepository.findByReleaseDateBetweenOrderByReleaseDateDesc(start, end));
        return "searched-page";
    }

    @GetMapping("/homePage2")
    public String homePage(
            @RequestParam(value = "search") String search,
            Model model) {

        if (search != null && !search.isBlank()) {

            model.addAttribute("movie", MovieUtil.convertTo(moviesRepository.searchEverything(search)));

        } else {

            model.addAttribute("trendingMovies", moviesRepository.findByPopularityGreaterThanOrderByPopularityDesc(50.0));
            model.addAttribute("newestMovies", moviesRepository.findByReleaseDateBetweenOrderByReleaseDateDesc(start, end));
        }

        return "home-page";
    }

    @GetMapping("/newsPage")
    public String newsPage(Model theModel){
        theModel.addAttribute("allNews", newsRepository.findAll());
        return "news";
    }
}