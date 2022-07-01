package com.yedam.quiz.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.quiz.student.mapper.StudentMapper;
import com.yedam.quiz.student.service.StudentService;
import com.yedam.quiz.student.service.StudentVO;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentMapper map;
	
	@Override
	public StudentVO getStudent(StudentVO vo) {
		
		return null;
	}

	@Override
	public List<StudentVO> getStudentList() {
		return map.getStudentList();
	}

	@Override
	public void insertStudent(StudentVO vo) {
		
	}

	@Override
	public void updateStudent(StudentVO vo) {
		
	}

	@Override
	public void deleteStudent(StudentVO vo) {
		
	}

}
