package com.yedam.quiz.comm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.quiz.comm.mapper.CodeMapper;
import com.yedam.quiz.comm.service.CodeService;
import com.yedam.quiz.comm.service.CodeVO;

@Service
public class CodeServiceImpl implements CodeService{

	@Autowired CodeMapper mapper;
	
	@Override
	public CodeVO getCode(CodeVO codeVO) {
		return mapper.getCode(codeVO);
	}

	public List<CodeVO> getCodeList(CodeVO codeVO) {
		return mapper.getCodeList(codeVO);
	}

	@Override
	public void insertCode(CodeVO codeVO) {
		mapper.insertCode(codeVO);
	}

	@Override
	public void updateCode(CodeVO codeVO) {
		mapper.updateCode(codeVO);
	}
	
	@Override
	public void deleteCode(CodeVO codeVO) {
		mapper.deleteCode(codeVO);
	}
	
	@Override
	public Map<String, List<CodeVO>> getCodes(String ... gpCdlist) { 
		Map<String, List<CodeVO>> map = new HashMap<String, List<CodeVO>>();
		for(String gpCd : gpCdlist) {
			map.put(gpCd, mapper.getCodeList(new CodeVO(gpCd)));
		}
		return map;
	}
	
    public List<CodeVO> getGpCodeList(CodeVO codeVO){	//그룹코드
    	return mapper.getGpCodeList(codeVO);
    }
}
