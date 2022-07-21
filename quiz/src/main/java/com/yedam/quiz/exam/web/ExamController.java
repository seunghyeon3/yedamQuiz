package com.yedam.quiz.exam.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.quiz.appl.service.ApplService;
import com.yedam.quiz.comm.Paging;
import com.yedam.quiz.comm.service.CodeService;
import com.yedam.quiz.comm.service.CodeVO;
import com.yedam.quiz.exam.service.ExamService;
import com.yedam.quiz.exam.service.ExamVO;
import com.yedam.quiz.question.service.QuestionService;
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

	@Autowired
	private CodeService codeService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private ApplService applService;

	@RequestMapping("examRegistForm")
	public String examRegistForm(Model model) {
		model.addAttribute("quizList", quizService.getQuizList(null));
		// 훈련생 리스트
		model.addAttribute("studentList", studentService.getStudentList());
		// 퀴즈 리스트
		model.addAttribute("sbjtList", codeService.getCodeList(new CodeVO("SBJT")));
		return "exam/examRegist";
	}

	@RequestMapping("examRegist")
	public String examRegist(ExamVO vo) {
		examService.insertExam(vo);

		for (int i = 0; i < vo.getStd().size(); i++) {
			applService.firstInsertAppl(vo.getExamNo(), vo.getStd().get(i).getStdNo());
		}

		for (int i = 0; i < vo.getQstn().size(); i++) {
			vo.getQstn().get(i).setQestnOrd(i + 1);
			vo.getQstn().get(i).setQestnScor(100 / (vo.getQstn().size()));
			vo.getQstn().get(i).setExamNo(vo.getExamNo());
			questionService.insertQuestion(vo.getQstn().get(i));
		}

//		questionService.insertQuestion();
		return "redirect:/examList";
	}

	@RequestMapping("examList")
	public String examList(Model model, ExamVO vo, Paging paging) {
		model.addAttribute("examList", examService.getExamList());

		vo.setStart(paging.getFirst());
		vo.setEnd(paging.getLast());
		paging.setTotalRecord(examService.getCount());
		model.addAttribute("paging", paging);

		return "exam/examList";
	}

	@RequestMapping("getExamList")
	public List<ExamVO> getExamList() {
		return examService.getExamList();
	}

	@RequestMapping("examView")
	public String examView(Model model, ExamVO vo) {
		model.addAttribute("examList", examService.getExam(vo));
		// 훈련생 리스트 넘겨줘야함.
		return "exam/examMod";
	}

	@RequestMapping("examModify")
	public String examModify(ExamVO vo) {
		System.out.println("수정쪽");
		examService.updateExam(vo);
		return "redirect:/examList";
	}

	@RequestMapping("examDelete")
	public String examDelete(ExamVO vo) {
		System.out.println("삭제쪽");
		examService.deleteExam(vo);
		return "redirect:/examList";
	}
}
