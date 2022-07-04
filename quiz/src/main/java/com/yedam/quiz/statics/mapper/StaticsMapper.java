package com.yedam.quiz.statics.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.quiz.statics.service.StaticsVO;

@Mapper
public interface StaticsMapper {
	public List<StaticsVO> getStaticsByQuiz(StaticsVO staticsVO);
}
