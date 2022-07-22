package com.yedam.quiz.student.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.quiz.student.service.ApplAnsrVO;

@Mapper
public interface ApplAnsrMapper {
	public List<ApplAnsrVO> getApplAnsrList(ApplAnsrVO applAnsrVO);
	public ApplAnsrVO getApplAnsr(ApplAnsrVO applAnsrVO);
	public void insertApplAnsr(ApplAnsrVO applAnsrVO);
	public void updateApplAnsr(ApplAnsrVO applAnsrVO);
	public void deleteApplAnsr(ApplAnsrVO applAnsrVO);
}
