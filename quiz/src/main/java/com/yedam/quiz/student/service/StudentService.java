package com.yedam.quiz.student.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentService {
	public StudentVO getStudent(StudentVO vo);
	public List<StudentVO> getStudentList();
	public void insertStudent(StudentVO vo);
	public void updateStudent(StudentVO vo);
	public void deleteStudent(StudentVO vo);
}
