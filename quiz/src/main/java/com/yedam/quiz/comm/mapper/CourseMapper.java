package com.yedam.quiz.comm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.quiz.comm.service.CorsVO;

@Mapper
public interface CourseMapper {
	public CorsVO getCourse(CorsVO courseVO);
	public List<CorsVO> getCourseList(CorsVO courseVO);
	public void insertCourse(CorsVO courseVO);
}
