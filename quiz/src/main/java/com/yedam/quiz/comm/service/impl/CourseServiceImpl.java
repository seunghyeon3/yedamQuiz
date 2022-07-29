package com.yedam.quiz.comm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.quiz.comm.mapper.CourseMapper;
import com.yedam.quiz.comm.service.CourseService;
import com.yedam.quiz.comm.service.CourseVO;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseMapper courseMapper;

	@Override
	public CourseVO getCourse(CourseVO courseVO) {
		return courseMapper.getCourse(courseVO);
	}

	@Override
	public List<CourseVO> getCourseList(CourseVO courseVO) {
		return courseMapper.getCourseList(courseVO);
	}

	@Override
	public void insertCourse(CourseVO courseVO) {
		courseMapper.insertCourse(courseVO);
	}

}
