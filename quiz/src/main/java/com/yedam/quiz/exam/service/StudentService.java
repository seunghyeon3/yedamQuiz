package com.yedam.quiz.exam.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentService {

	public List<StudentVO> getStudentList();
}
