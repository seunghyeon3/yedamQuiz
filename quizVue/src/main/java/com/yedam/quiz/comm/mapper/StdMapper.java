package com.yedam.quiz.comm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.quiz.comm.service.CorsVO;
import com.yedam.quiz.comm.service.StdReqVO;
import com.yedam.quiz.comm.service.StdVO;

@Mapper
public interface StdMapper {
	public StdVO getStudent(StdVO vo);
	public List<StdVO> getStudentList(StdVO vo);
	public void insertStudent(StdVO vo);
	public void updateStudent(StdVO vo);
	public void deleteStudent(StdVO vo);
	
	public int getCount(StdVO vo);
	public String getStdNo(StdVO vo);
	public int updateUseYn(StdReqVO vo);
	public List<CorsVO> getCorsList();
}
