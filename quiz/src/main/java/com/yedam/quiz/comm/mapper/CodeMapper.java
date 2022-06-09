package com.yedam.quiz.comm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.quiz.comm.service.CodeVO;

@Mapper
public interface CodeMapper {
    public CodeVO getCode(CodeVO codeVO);
    public List<CodeVO> getCodeList(CodeVO codeVO);
    public void insertCode(CodeVO codeVO);
    public void updateCode(CodeVO codeVO);
    public void deleteCode(CodeVO codeVO);
}
