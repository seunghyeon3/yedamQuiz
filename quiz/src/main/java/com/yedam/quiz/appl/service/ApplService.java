package com.yedam.quiz.appl.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApplService {
	public ApplVO getAppl(ApplVO vo);
	public List<ApplVO> getApplList();
	public void insertAppl(ApplVO vo);
	public void firstInsertAppl(int examNo, String stdNo);
	public void updateAppl(ApplVO vo);
	public void deleteAppl(ApplVO vo);
}
