package com.yedam.quiz.student.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.quiz.exam.service.ExamService;
import com.yedam.quiz.exam.service.ExamVO;
import com.yedam.quiz.student.service.ApplService;
import com.yedam.quiz.student.service.ApplVO;
import com.yedam.quiz.student.service.StudentService;
import com.yedam.quiz.student.service.StudentVO;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ApplService applService;
	
	@Autowired
	private ExamService examService;	


	@GetMapping("login")
	public String loginForm(Model model) {
		return "student/login";
	}
	
	
	@PostMapping("loginInfo")
	@ResponseBody
	public String studentInfo(StudentVO studentVO, Model model) {
		StudentVO loginInfo = studentService.getStudent(studentVO);
		
		if(loginInfo == null) {
			return "fail";
		}else {
			return "success";
		}
	}
	@PostMapping("mypage")
	public String mypage(StudentVO studentVO, Model model) {
		//학번과 이름 -> 학번, 이름, 과정번호, 과정명
		StudentVO studentInfo = studentService.getStudent(studentVO);
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
		StudentVO studentInfo = new StudentVO();
		studentInfo.setStdNo(stdNo);
		studentInfo = studentService.getStudent(studentInfo);
		model.addAttribute("studentInfo", studentInfo);
		
		//시험지 정보
		ExamVO examVO = new ExamVO();
		examVO.setExamNo(examNo);
		examVO = examService.getExam(examVO);
		model.addAttribute("examInfo", examVO);
		
		//문제 정보
		
		
		//보기 정보
		
		
		return "student/exam";
	}
	
	@PostMapping("studentResult")
	public String studentResult(int examNo, String stdNo, Model model) {
		//학생 정보
		StudentVO studentInfo = new StudentVO();
		studentInfo.setStdNo(stdNo);
		studentInfo = studentService.getStudent(studentInfo);
		model.addAttribute("studentInfo", studentInfo);
		
		//시험지 정보
		ExamVO examVO = new ExamVO();
		examVO.setExamNo(examNo);
		examVO = examService.getExam(examVO);
		model.addAttribute("examInfo", examVO);
		
		//문제 정보
		
		//보기 정보
		
		//응시자답안 정보		
		
		return "student/result";
	}
	
}
