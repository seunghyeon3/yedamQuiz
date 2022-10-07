package com.yedam.quiz.student.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.quiz.student.service.ApplVO;

@Mapper
public interface ApplMapper {
	public List<ApplVO> getApplList(ApplVO applVO);
	public ApplVO getAppl(ApplVO applVO);
	public void insertAppl(ApplVO applVO);
	public void updateAppl(ApplVO applVO);
	public void deleteAppl(ApplVO applVO);
	public void firstInsertAppl(int examNo,String stdNo);
	public void getExamResult(ApplVO applVO);
}
