package com.filmdome.webserver.repository;

import com.filmdome.webserver.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Integer> {
    News findById(int id);
}