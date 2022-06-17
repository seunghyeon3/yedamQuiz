package com.yedam.quiz.exam.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.quiz.exam.service.ExamService;
import com.yedam.quiz.exam.service.ExamVO;
import com.yedam.quiz.quiz.service.QuizService;

@Controller
public class ExamController {
	
	@Autowired
	private ExamService examService;
	
	@Autowired
	private QuizService quizService;
	
	//훈련생 리스트 받아오는 부분 추가 해줘야함.
	
	
	@RequestMapping("examRegistForm")
	public String examRegistForm(Model model) {
		model.addAttribute("quizList", quizService.getQuizList(null));
		//훈련생 리스트
		model.addAttribute("studnetList", null);
		return "exam/examRegist";
	}
	
	@RequestMapping("examRegist")
	public String examRegist(ExamVO vo) {
		examService.insertExam(vo);
		return "exam/examList";
	}
	
	@RequestMapping("examList")
	public String examList() {
		return "exam/examList";
	}
	
	@RequestMapping("getExamList")
	public List<ExamVO> getExamList() {
		return examService.getExamList();
	}
}
