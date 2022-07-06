package com.yedam.quiz.statics.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
/*
 * 작성자 : 이창호
 * 작성일자 : 2022-07-01 
 * 문제별 통계정보 : 문제별 통계 데이터.
 */
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.quiz.statics.service.StaticsService;
import com.yedam.quiz.statics.service.StaticsVO;

@Controller
public class StaticsController {

	@Autowired
	StaticsService service;

	// 문제별 통계정보.
	@GetMapping("/staticsByQuiz")
	public String staticsByQuiz(Model model, StaticsVO vo) {
		System.out.println("staticsByQuiz call()");
		model.addAttribute("list", service.getStaticsByQuiz(vo));
		return "statics/listByQuiz";
	}
}
