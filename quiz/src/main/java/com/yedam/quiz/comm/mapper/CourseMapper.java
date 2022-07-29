package com.yedam.quiz.comm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.quiz.comm.service.CourseVO;

@Mapper
public interface CourseMapper {
	public CourseVO getCourse(CourseVO courseVO);
	public List<CourseVO> getCourseList(CourseVO courseVO);
	public void insertCourse(CourseVO courseVO);
}
