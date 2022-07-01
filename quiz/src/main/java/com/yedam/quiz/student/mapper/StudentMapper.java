package com.yedam.quiz.student.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.quiz.student.service.StudentVO;

@Mapper
public interface StudentMapper {
	public StudentVO getStudent(StudentVO vo);
	public List<StudentVO> getStudentList();
	public void insertStudent(StudentVO vo);
	public void updateStudent(StudentVO vo);
	public void deleteStudent(StudentVO vo);
	
}
