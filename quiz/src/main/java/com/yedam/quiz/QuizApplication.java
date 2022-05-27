package com.yedam.quiz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class QuizApplication {
    private static final Logger log = LoggerFactory.getLogger(QuizApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(QuizApplication.class, args);
    }
    
    @RequestMapping("/")
    public String index() {
    	return "index";
    }
}
