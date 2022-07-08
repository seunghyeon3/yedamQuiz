package com.yedam.quiz.exam.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExamService {
	public ExamVO getExam(ExamVO vo);
	public List<ExamVO> getExamList();
	public void insertExam(ExamVO vo);
	public void updateExam(ExamVO vo);
	public void deleteExam(ExamVO vo);
	public int getCount();
}
