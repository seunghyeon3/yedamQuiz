package com.yedam.quiz.statics.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface StaticsService {
	public List<StaticsVO> getStaticsByQuiz(StaticsVO staticsVO);
}
