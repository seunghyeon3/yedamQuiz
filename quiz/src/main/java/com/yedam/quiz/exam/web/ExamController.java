package com.yedam.quiz.exam.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.quiz.exam.service.ExamService;

@Controller
public class ExamController {
	
	@Autowired
	private ExamService examService;
	
	@RequestMapping("examRegistForm")
	public void examRegistForm() {
		
	}
	
	@RequestMapping("examRegist")
	public void  examRegist() {
		
	}
}
