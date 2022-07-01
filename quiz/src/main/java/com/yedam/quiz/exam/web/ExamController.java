package com.yedam.quiz.exam.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.quiz.exam.service.ExamService;
import com.yedam.quiz.exam.service.ExamVO;
import com.yedam.quiz.exam.service.StudentService;
import com.yedam.quiz.quiz.service.QuizService;
import com.yedam.quiz.student.service.StudentService;
import com.yedam.quiz.student.service.StudentVO;

@Controller
public class ExamController {
	
	@Autowired
	private ExamService examService;
	
	@Autowired
	private QuizService quizService;
	
	@Autowired
<<<<<<< HEAD
	private StudentService studentService;
	
=======
	private StudentService stuService;
>>>>>>> e37f085fcf6358ec84cecdea5bd92b4132d180ad
	
	@RequestMapping("examRegistForm")
	public String examRegistForm(Model model) {
		model.addAttribute("quizList", quizService.getQuizList(null));
		//훈련생 리스트
<<<<<<< HEAD
		model.addAttribute("studentList", studentService.getStudentList());
=======
		model.addAttribute("studentList", stuService.getStudentList());
>>>>>>> e37f085fcf6358ec84cecdea5bd92b4132d180ad
		return "exam/examRegist";
	}
	
	@RequestMapping("examRegist")
	public String examRegist(ExamVO vo) {
		examService.insertExam(vo);
		return "exam/examList";
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
}
