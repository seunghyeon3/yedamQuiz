package com.yedam.quiz.comm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.quiz.comm.mapper.CourseMapper;
import com.yedam.quiz.comm.service.CourseService;
import com.yedam.quiz.comm.service.CorsVO;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseMapper courseMapper;

	@Override
	public CorsVO getCourse(CorsVO courseVO) {
		return courseMapper.getCourse(courseVO);
	}

	@Override
	public List<CorsVO> getCourseList(CorsVO courseVO) {
		return courseMapper.getCourseList(courseVO);
	}

	@Override
	public void insertCourse(CorsVO courseVO) {
		courseMapper.insertCourse(courseVO);
	}

}
