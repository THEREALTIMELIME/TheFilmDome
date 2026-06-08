package com.loginwebsite.websiteproject.repository;

import com.loginwebsite.websiteproject.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Integer> {
    News findById(int id);
}