package com.yedam.quiz.comm.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CodeService {
    public CodeVO getCode(CodeVO codeVO);
    public List<CodeVO> getCodeList(CodeVO codeVO);
    public void insertCode(CodeVO codeVO);
    public void updateCode(CodeVO codeVO);
    public void deleteCode(CodeVO codeVO);
    public Map<String, List<CodeVO>> getCodes(String ... gpCdlist);
}
