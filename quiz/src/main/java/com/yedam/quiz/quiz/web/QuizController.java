package com.yedam.quiz.quiz.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.quiz.quiz.service.QuizService;
import com.yedam.quiz.quiz.service.QuizVO;

@Controller
public class QuizController {
	
	@Autowired QuizService quizService;
	@GetMapping("quizList")
	public String quizList(Model model, QuizVO vo) {
		model.addAttribute("quizList", quizService.getQuizList(vo));
		return "quiz/list";
	}
}
