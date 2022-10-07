package com.yedam.quiz.student.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApplAnsrService {
	public List<ApplAnsrVO> getApplAnsrList(ApplAnsrVO applAnsrVO);
	public ApplAnsrVO getApplAnsr(ApplAnsrVO applAnsrVO);
	public void insertApplAnsr(ApplAnsrVO applAnsrVO);
	public void updateApplAnsr(ApplAnsrVO applAnsrVO);
	public void deleteApplAnsr(ApplAnsrVO applAnsrVO);
	
	public void insertApplAnsrList(List<ApplAnsrVO> ansrList);
}
