package com.yedam.quiz.comm.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

@Mapper
public interface StdService {
	public StdVO getStudent(StdVO vo);
	public List<StdVO> getStudentList(StdVO vo);
	public void insertStudent(StdVO vo);
	public void updateStudent(StdVO vo);
	public void deleteStudent(StdVO vo);
	public int getCount(StdVO vo);
	public int updateUseYn(StdReqVO vo);
	public Map<String, Object> batchReg(MultipartFile file, StdVO vo);
}
