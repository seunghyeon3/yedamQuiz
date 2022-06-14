package com.yedam.quiz.student.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

	@GetMapping("login")
	public String loginForm(Model model) {
		return "student/login";
	}
	
	@GetMapping("mypage")
	public String mypage(Model model) {
		return "student/mypage";
	}
}
