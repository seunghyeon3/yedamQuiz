package com.yedam.quiz.comm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.quiz.comm.mapper.CodeMapper;
import com.yedam.quiz.comm.service.CodeService;
import com.yedam.quiz.comm.service.CodeVO;
import com.yedam.quiz.comm.service.GridData;

@Service
public class CodeServiceImpl implements CodeService{

	@Autowired CodeMapper mapper;
	
	@Override
	public CodeVO getCode(CodeVO codeVO) {
		return mapper.getCode(codeVO);
	}

	//하나의 그룹코드에 대한 상세코드 조회
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
	
	//여러 그룹코드들의 상세코드 조회
	@Override
	public Map<String, List<CodeVO>> getCodes(String ... gpCdlist) { 
		Map<String, List<CodeVO>> map = new HashMap<String, List<CodeVO>>();
		for(String gpCd : gpCdlist) {
			map.put(gpCd, mapper.getCodeList(new CodeVO(gpCd)));
		}
		return map;
	}
	
	//그룹코드 조회
    public List<CodeVO> getGpCodeList(CodeVO codeVO){	
    	return mapper.getGpCodeList(codeVO);
    }
    
    //코드 수정
    public void updateCodeData(GridData<CodeVO> data) {
    	if (data.getCreatedRows() != null) {
    		for(CodeVO vo   : data.getCreatedRows()) {
    			mapper.insertCode(vo);
    		}
    	}
    	if (data.getDeletedRows() != null) {
    		for(CodeVO vo   : data.getDeletedRows()) {
    			mapper.deleteCode(vo);
    		}
    	}
    	if (data.getUpdatedRows() != null) {
    		for(CodeVO vo   : data.getUpdatedRows()) {
    			mapper.updateCode(vo);
    		}
    	}    	
    }
}
