package com.yedam.quiz.comm.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

public interface CourseService {

	public CourseVO getCourse(CourseVO courseVO);
	public List<CourseVO> getCourseList(CourseVO courseVO);
	public void insertCourse(CourseVO courseVO);
}
