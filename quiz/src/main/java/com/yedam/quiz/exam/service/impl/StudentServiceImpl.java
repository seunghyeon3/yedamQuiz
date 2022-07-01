package com.yedam.quiz.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.quiz.exam.mapper.StudentMapper;
import com.yedam.quiz.exam.service.StudentService;
import com.yedam.quiz.exam.service.StudentVO;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentMapper map;
	
	@Override
	public List<StudentVO> getStudentList() {	
		return map.getStudentList();
	}

	
	
}
