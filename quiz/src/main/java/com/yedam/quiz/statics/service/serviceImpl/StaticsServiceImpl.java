package com.yedam.quiz.statics.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.quiz.statics.mapper.StaticsMapper;
import com.yedam.quiz.statics.service.StaticsService;
import com.yedam.quiz.statics.service.StaticsVO;

@Service
public class StaticsServiceImpl implements StaticsService {

	@Autowired
	StaticsMapper mapper;

	@Override
	public List<StaticsVO> getStaticsByQuiz(StaticsVO staticsVO) {
		return null;
	}

}
