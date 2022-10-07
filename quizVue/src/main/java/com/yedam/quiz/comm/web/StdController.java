package com.yedam.quiz.comm.web;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.quiz.comm.Paging;
import com.yedam.quiz.comm.mapper.StdMapper;
import com.yedam.quiz.comm.service.CodeService;
import com.yedam.quiz.comm.service.StdReqVO;
import com.yedam.quiz.comm.service.StdService;
import com.yedam.quiz.comm.service.StdVO;

@Controller
public class StdController {

	@Autowired CodeService codeService;
	@Autowired StdService stdService;
	@Autowired StdMapper stdMapper;
	
	//학생 목록	
	@GetMapping("/stdList")
	public String stdList(Model model, StdVO vo, Paging paging) {
		
		//과정목록조회
		model.addAttribute("corss", stdMapper.getCorsList());
		
		//페이징처리
		vo.setStart(paging.getFirst());
		vo.setEnd(paging.getLast()); 
		paging.setTotalRecord(stdService.getCount(vo)); 
		model.addAttribute("paging", paging);
		
		//학생목록
		model.addAttribute("stdList", stdService.getStudentList(vo));
		return "stdmng/list";
	}

	//학생개별 등록 페이지
	@GetMapping("/stdReg")
	public String stdRegForm(Model model, StdVO vo) {
		//과정목록조회
		model.addAttribute("corss", stdMapper.getCorsList());
		return "stdmng/reg";
	}
	
	//학생 개별 등록 처리
	@PostMapping("/stdReg")
	public String stdRegProc(Model model, StdVO vo, 
							 RedirectAttributes rdt,
			                 @RequestParam(required = false, defaultValue = "N") String contYn) {
		//학생 등록
		stdService.insertStudent(vo);
		rdt.addFlashAttribute("corsNo", vo.getCorsNo());
		
		//저장 후 신규추가이면 등록페이지로 이동
		if(contYn.equals("Y")) {			
			return "redirect:/stdReg";
		}else {
			return "redirect:/stdList";
		}
	}
	

	
	//일괄 등록 처리(엑셀파일 업로드)
	@PostMapping("/batchReg")
	public ResponseEntity<Map<String,Object>> batchReg(Model model, MultipartFile file, StdVO vo) {
		return ResponseEntity.ok().body(stdService.batchReg(file, vo));
	}
	
	//학생 수정 페이지
	@GetMapping("/stdUpd")
	public String stdUpdForm(Model model, StdVO vo) {
		//공통코드조회
		model.addAttribute("codes", codeService.getCodes("SBJT","TYP"));
		model.addAttribute("std", stdService.getStudent(vo));
		return "stdmng/upd";
	}
	
	//학생 수정 처리
	@PostMapping("/stdUpd")
	public String stdUpdProc(Model model, StdVO vo) {
		//학생 수정
		stdService.updateStudent(vo);
		
		return "redirect:/stdList";
	}
	
	//학생 삭제 처리
	@GetMapping("/stdDel")
	public String stdDelProc(Model model, StdVO vo) {
		//학생 수정
		stdService.deleteStudent(vo);
		
		return "redirect:/stdList";
	}
	
	//선택사용/미사용변경
	@PostMapping("/stdUpdateUseYn")  
	@ResponseBody
	public Map<String, Integer> updateUseYn(Model model, @RequestBody StdReqVO vo) {
		//사용여부변경
		int result = stdService.updateUseYn(vo);		
		return Collections.singletonMap("cnt", result);
	}	

}
