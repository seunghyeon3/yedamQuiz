package com.yedam.quiz.comm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.quiz.comm.service.CodeService;
import com.yedam.quiz.comm.service.CodeVO;

@Controller
public class CodeController {

	@Autowired CodeService codeService;
	
	//코드관리 페이지로 이동	
	@GetMapping("/codeList")
	public String codeList(Model model, CodeVO vo) {
		return "code/list";
	}
	
	//그룹코드 조회
	@ResponseBody
	@GetMapping("/codeGroup")
	public List<CodeVO> codeGroup(Model model, CodeVO vo) {
		return codeService.getGpCodeList(vo);
	}

	//상세코드 조회
	@ResponseBody
	@GetMapping("/codeDetail")
	public List<CodeVO> codeDetail(Model model, CodeVO vo) {
		return codeService.getCodeList(vo);
	}
}
