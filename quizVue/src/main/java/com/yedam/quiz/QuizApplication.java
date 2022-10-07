package com.yedam.quiz;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Controller
@SpringBootApplication
public class QuizApplication {
    private static final Logger log = LoggerFactory.getLogger(QuizApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(QuizApplication.class, args);
    }
    
    @Bean
    public LocaleResolver localeResolver() {
    	SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
    	sessionLocaleResolver.setDefaultLocale(Locale.KOREA);
    	return sessionLocaleResolver;
    }
    
    @RequestMapping("/")
    public String index() {
    	return "index";
    }
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");  // allowedOrigins("http://dddd","http://")
            }
        };
    }
}
