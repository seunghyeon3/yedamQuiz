package com.yedam.quiz.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.quiz.exam.mapper.ExamMapper;
import com.yedam.quiz.exam.service.ExamService;
import com.yedam.quiz.exam.service.ExamVO;

@Service
public class ExamServiceImpl implements ExamService{

	@Autowired
	ExamMapper map;
	
	@Override
	public ExamVO getExam(ExamVO vo) {
		return map.getExam(vo);
	}

	@Override
	public List<ExamVO> getExamList() {
		return map.getExamList();
	}

	@Override
	public void insertExam(ExamVO vo) {
		map.insertExam(vo);
	}

	@Override
	public void updateExam(ExamVO vo) {
		map.updateExam(vo);
	}

	@Override
	public void deleteExam(ExamVO vo) {
		map.deleteExam(vo);
	}

	@Override
	public int getCount() {
		return map.getCount();
	}

}
