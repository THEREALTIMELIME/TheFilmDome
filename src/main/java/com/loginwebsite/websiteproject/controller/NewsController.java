package com.loginwebsite.websiteproject.controller;

import com.loginwebsite.websiteproject.entity.News;
import com.loginwebsite.websiteproject.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NewsController {
    @Autowired
    private NewsRepository newsRepository;

    @RequestMapping(value = "/newsSelection", method = RequestMethod.GET)
    public String newsSelection(@RequestParam("id") int id, Model model) {
        News news = newsRepository.findById(id);

        if (news != null) {
            model.addAttribute("news", news);
            return "news-info";
        } else {
            return "error";
        }
    }
}