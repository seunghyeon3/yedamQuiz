package com.yedam.quiz.comm.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

public interface CourseService {

	public CorsVO getCourse(CorsVO courseVO);
	public List<CorsVO> getCourseList(CorsVO courseVO);
	public void insertCourse(CorsVO courseVO);
}
