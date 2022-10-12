package com.yedam.quiz.quiz.web;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.quiz.comm.Paging;
import com.yedam.quiz.comm.service.CodeService;
import com.yedam.quiz.quiz.service.QuizReqVO;
import com.yedam.quiz.quiz.service.QuizService;
import com.yedam.quiz.quiz.service.QuizVO;
/*
 * 작성자 : 김유미
 * 작성일자 : 2022-06-09
 * 문제은행 관리 : 믄제등록, 목록조회, 문제복사, 미리보기, 엑셀
 */
@RestController
public class QuizController {
	
	@Autowired CodeService codeService;
	@Autowired QuizService quizService;
	
	//문제 목록	
	@GetMapping("/quizList")
	public Map<String, Object> quizList(Model model, QuizVO vo, Paging paging) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		//공통코드조회
		map.put("codes", codeService.getCodes("SBJT","TYP"));
		
		//페이징처리
		vo.setStart(paging.getFirst());
		vo.setEnd(paging.getLast()); 
		paging.setTotalRecord(quizService.getCount(vo));
		map.put("paging", paging);
		
		//문제목록
		map.put("quizList", quizService.getQuizList(vo));
		return map;
	}

	
	//문제 등록 처리
	@PostMapping("/quizReg")
	public QuizVO quizRegProc( QuizVO vo) {
		//문제 등록
		quizService.insertQuiz(vo);
		return vo;
	}
	
	
	//문제 단건조회
	@GetMapping("/quizUpd")
	public QuizVO quizUpdForm(QuizVO vo) {
		//공통코드조회
		//model.addAttribute("codes", codeService.getCodes("SBJT","TYP"));
		return quizService.getQuiz(vo);
	}
	
	//문제 수정 처리
	@PostMapping("/quizUpd")
	public QuizVO quizUpdProc(QuizVO vo) {
		//문제 수정
		quizService.updateQuiz(vo);
		
		return vo;
	}
	
	//문제 삭제 처리
	@GetMapping("/quizDel")
	public QuizVO quizDelProc(QuizVO vo) {
		//문제 수정
		quizService.deleteQuiz(vo);
		
		return vo;
	}
	
	//선택사용/미사용변경
	@PostMapping("/quizUpdateUseYn")  
	public Map<String, Integer> updateUseYn(Model model, @RequestBody QuizReqVO vo) {
		//사용여부변경
		int result = quizService.updateUseYn(vo);		
		return Collections.singletonMap("cnt", result);
	}	

	
	//문제 복제
	
	//미리보기
}
