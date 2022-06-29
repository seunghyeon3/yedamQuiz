package com.yedam.quiz.quiz.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.quiz.comm.Paging;
import com.yedam.quiz.comm.service.CodeService;
import com.yedam.quiz.quiz.service.QuizService;
import com.yedam.quiz.quiz.service.QuizVO;
/*
 * 작성자 : 김유미
 * 작성일자 : 2022-06-09
 * 문제은행 관리 : 믄제등록, 목록조회, 문제복사, 미리보기, 엑셀
 */
@Controller
public class QuizController {
	
	@Autowired CodeService codeService;
	@Autowired QuizService quizService;
	
	//문제 목록	
	@GetMapping("/quizList")
	public String quizList(Model model, QuizVO vo, Paging paging) {
		
		//공통코드조회
		model.addAttribute("codes", codeService.getCodes("SBJT","TYP"));
		
		//페이징처리
		vo.setStart(paging.getFirst());
		vo.setEnd(paging.getLast()); 
		paging.setTotalRecord(quizService.getCount(vo));
		model.addAttribute("paging", paging);
		
		//문제목록
		model.addAttribute("quizList", quizService.getQuizList(vo));
		return "quiz/list";
	}

	
	//문제 등록 페이지
	@GetMapping("/quizReg")
	public String quizRegForm(Model model, QuizVO vo) {
		//공통코드조회
		model.addAttribute("codes", codeService.getCodes("SBJT","TYP"));
		return "quiz/reg";
	}
	
	//문제 등록 처리
	@PostMapping("/quizReg")
	public String quizRegProc(Model model, QuizVO vo, @RequestParam(required = false, defaultValue = "N") String contYn) {
		//문제 등록
		quizService.insertQuiz(vo);
		
		//저장 후 신규추가이면 등록페이지로 이동
		if(contYn.equals("Y")) {			
			return "redirect:/quizReg";
		}else {
			return "redirect:/quizList";
		}
	}
	
	
	//문제 수정 페이지
	@GetMapping("/quizUpd")
	public String quizUpdForm(Model model, QuizVO vo) {
		//공통코드조회
		model.addAttribute("codes", codeService.getCodes("SBJT","TYP"));
		model.addAttribute("quiz", quizService.getQuiz(vo));
		return "quiz/upd";
	}
	
	//문제 수정 처리
	@PostMapping("/quizUpd")
	public String quizUpdProc(Model model, QuizVO vo) {
		//문제 수정
		quizService.updateQuiz(vo);
		
		return "redirect:/quizList";
	}
	
	//문제 삭제 처리
	@GetMapping("/quizDel")
	public String quizDelProc(Model model, QuizVO vo) {
		//문제 수정
		quizService.deleteQuiz(vo);
		
		return "redirect:/quizList";
	}
	
	//문제 복제
	
	//미리보기
}
