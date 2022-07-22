package com.yedam.quiz.appl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yedam.quiz.appl.service.ApplVO;


@Mapper
public interface ApplMapper {
	public ApplVO getAppl(ApplVO vo);
	public List<ApplVO> getApplList();
	public void insertAppl(ApplVO vo);
	public void firstInsertAppl(int examNo,String stdNo);
	public void updateAppl(ApplVO vo);
	public void deleteAppl(ApplVO vo);
}
