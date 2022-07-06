package com.yedam.quiz.statics.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StaticsService {
	public List<StaticsVO> getStaticsByQuiz(StaticsVO staticsVO);
}
