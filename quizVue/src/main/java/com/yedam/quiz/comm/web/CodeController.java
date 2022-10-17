package com.yedam.quiz.comm.web;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.quiz.comm.service.CodeService;
import com.yedam.quiz.comm.service.CodeVO;
import com.yedam.quiz.comm.service.GridData;

@RestController
public class CodeController {

	@Autowired CodeService codeService;
	
	@GetMapping("/getCodes")
	public Map<String, List<CodeVO>> getCodes(String codes){
		return codeService.getCodes(codes.split(","));
	}
	
	//그룹코드 조회
	@GetMapping("/codeGroup")
	public Map<String, Object> codeGroup(Model model, CodeVO vo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", true);
		map.put("data", Collections.singletonMap("contents", codeService.getGpCodeList(vo)));
		return map;
	}

	//상세코드 조회
	@GetMapping("/codeDetail")
	public Map<String, Object> codeDetail(Model model, CodeVO vo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", true);
		map.put("data", Collections.singletonMap("contents", codeService.getCodeList(vo)));
		return map;
	}
	
	//코드 수정
	@ResponseBody
	@PutMapping("/codeUpdagte")
	public boolean codeUpdate(@RequestBody GridData<CodeVO> data){
		codeService.updateCodeData(data);
		return true;
	}
	
}
