package com.yedam.quiz.exam.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.quiz.exam.service.ExamService;
import com.yedam.quiz.exam.service.ExamVO;
import com.yedam.quiz.quiz.service.QuizService;
import com.yedam.quiz.student.service.StudentService;

@Controller
public class ExamController {
	
	@Autowired
	private ExamService examService;
	
	@Autowired
	private QuizService quizService;
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("examRegistForm")
	public String examRegistForm(Model model) {
		model.addAttribute("quizList", quizService.getQuizList(null));
		//훈련생 리스트
		model.addAttribute("studentList", studentService.getStudentList());
		return "exam/examRegist";
	}
	
	@RequestMapping("examRegist")
	public String examRegist(ExamVO vo) {
		examService.insertExam(vo);
		return "redirect:/examList";
	}
	
	@RequestMapping("examList")
	public String examList(Model model) {
		model.addAttribute("examList", examService.getExamList());
		return "exam/examList";
	}
	
	@RequestMapping("getExamList")
	public List<ExamVO> getExamList() {
		return examService.getExamList();
	}
	
	@RequestMapping("examView")
	public String examView(Model model, ExamVO vo) {
		System.out.println(examService.getExam(vo));
		model.addAttribute("examList", examService.getExam(vo));
		return "exam/examMod";
	}
}
