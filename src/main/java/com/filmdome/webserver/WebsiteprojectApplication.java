package com.filmdome.webserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@EntityScan({
		"com.filmdome.movies.entity",
		"com.loginwebsite.websiteproject.entity"
})
@EnableJpaRepositories({
		"com.filmdome.movies.repository",
		"com.loginwebsite.websiteproject.repository"
})
public class WebsiteprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsiteprojectApplication.class, args);
	}
}