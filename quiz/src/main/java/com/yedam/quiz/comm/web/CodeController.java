package com.yedam.quiz.comm.web;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.quiz.comm.service.CodeService;
import com.yedam.quiz.comm.service.CodeVO;
import com.yedam.quiz.comm.service.GridData;

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
	public Map<String, Object> codeGroup(Model model, CodeVO vo) {
/*		{
			  "result": true,
			  "data": {
			    "contents": [],*/
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", true);
		map.put("data", Collections.singletonMap("contents", codeService.getGpCodeList(vo)));
		return map;
	}

	//상세코드 조회
	@ResponseBody
	@GetMapping("/codeDetail")
	public Map<String, Object> codeDetail(Model model, CodeVO vo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", true);
		map.put("data", Collections.singletonMap("contents", codeService.getCodeList(vo)));
		return map;
	}
	
	//코드수정
	@ResponseBody
	@PutMapping("/codeUpdagte")
	public Map<String, Object> codeUpdate(@RequestBody GridData<CodeVO> data){
		codeService.updateCodeData(data);
		return null;
	}
	
}
