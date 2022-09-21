package com.yedam.quiz.users.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {

	@GetMapping("/admin/login")
	public String loginForm(Model model) {
		return "users/login";
	}
	
	@GetMapping("/admin/denyed")
	public String denyed(Model model) {
		return "users/403";
	}
	
	@GetMapping("/admin/loginError")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "users/login";
	}
}
