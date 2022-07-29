package com.yedam.quiz.student.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.quiz.comm.service.StdService;
import com.yedam.quiz.comm.service.StdVO;
import com.yedam.quiz.exam.service.ExamService;
import com.yedam.quiz.exam.service.ExamVO;
import com.yedam.quiz.exam.service.QuestionService;
import com.yedam.quiz.exam.service.QuestionVO;
import com.yedam.quiz.quiz.service.SectionService;
import com.yedam.quiz.student.service.ApplAnsrService;
import com.yedam.quiz.student.service.ApplAnsrVO;
import com.yedam.quiz.student.service.ApplService;
import com.yedam.quiz.student.service.ApplVO;

@Controller
public class StudentController {
	@Autowired
	private StdService studentService;
	
	@Autowired
	private ApplService applService;
	
	@Autowired
	private ExamService examService;	
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private SectionService sectionService;

	@Autowired
	private ApplAnsrService applAnsrService;
	
	@GetMapping("login")
	public String loginForm(Model model) {
		return "student/login";
	}
	
	
	@PostMapping("loginInfo")
	@ResponseBody
	public String studentInfo(StdVO studentVO, Model model) {
		StdVO loginInfo = studentService.getStudent(studentVO);
		
		if(loginInfo == null) {
			return "fail";
		}else {
			return "success";
		}
	}
	@PostMapping("mypage")
	public String mypage(StdVO studentVO, Model model) {
		//학번과 이름 -> 학번, 이름, 과정번호, 과정명
		StdVO studentInfo = studentService.getStudent(studentVO);
		model.addAttribute("student", studentInfo);
		
		//학생번호 -> 시험지번호, 시험지명, 시작일시, 종료일시, 응시일시(응시여부확인차)
		ApplVO applVO = new ApplVO();
		applVO.setStdNo(studentInfo.getStdNo());
		List<ApplVO> list  = applService.getApplList(applVO);
		model.addAttribute("applList", list);
		
		return "student/mypage";
	}
	
	@PostMapping("studentExam")
	public String studentExam(int examNo, String stdNo, Model model) {
		//학생 정보
		StdVO studentInfo = new StdVO();
		studentInfo.setStdNo(stdNo);
		studentInfo = studentService.getStudent(studentInfo);
		model.addAttribute("studentInfo", studentInfo);
		
		//시험지 정보
		ExamVO examVO = new ExamVO();
		examVO.setExamNo(examNo);
		examVO = examService.getExam(examVO);
		model.addAttribute("examInfo", examVO);
		
		//문제 정보
		QuestionVO questionVO = new QuestionVO();
		questionVO.setExamNo(examNo);
		List<QuestionVO> qList = questionService.getQuestionList(questionVO);
		model.addAttribute("quizList", qList);
		
		//보기 정보
		model.addAttribute("sectionInfo", sectionService.getSectionPerQuiz(qList));
		
		return "student/exam";
	}
	
	@PostMapping("gradeExam")
	public String gradeExam(ApplAnsrVO vo, Model model, RedirectAttributes reAttr) {
		//응시자답안 등록
		applAnsrService.insertApplAnsrList(vo.getAnsrlist());
		return "redirect:/studentResult";
	}
	
	@PostMapping("studentResult")
	public String studentResult(int examNo, String stdNo, Model model) {
		//학생 정보
		StdVO studentInfo = new StdVO();
		studentInfo.setStdNo(stdNo);
		studentInfo = studentService.getStudent(studentInfo);
		model.addAttribute("studentInfo", studentInfo);
		
		//시험지 정보
		ExamVO examVO = new ExamVO();
		examVO.setExamNo(examNo);
		examVO = examService.getExam(examVO);
		model.addAttribute("examInfo", examVO);
		
		//문제 정보
		QuestionVO questionVO = new QuestionVO();
		questionVO.setExamNo(examNo);
		List<QuestionVO> qList = questionService.getQuestionList(questionVO);
		model.addAttribute("quizList", qList);
		
		//보기 정보
		model.addAttribute("sectionInfo", sectionService.getSectionPerQuiz(qList));
		
		//응시자답안 정보		
		
		return "student/result";
	}
	
}
