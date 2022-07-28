package com.yedam.quiz.student.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApplService {
	public List<ApplVO> getApplList(ApplVO applVO);
	public ApplVO getAppl(ApplVO applVO);
	public void insertAppl(ApplVO applVO);
	public void updateAppl(ApplVO applVO);
	public void deleteAppl(ApplVO applVO);
	public void firstInsertAppl(int examNo,String stdNo);
	public void getExamResult(ApplVO applVO);
}
