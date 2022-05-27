package com.yedam.quiz.quiz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.quiz.quiz.mapper.QuizMapper;
import com.yedam.quiz.quiz.service.QuizService;
import com.yedam.quiz.quiz.service.QuizVO;

@Service
public class QuizServiceImpl implements QuizService{

	@Autowired QuizMapper mapper;
	
	@Override
	public QuizVO getQuiz(QuizVO quizVO) {
		return mapper.getQuiz(quizVO);
	}

	@Override
	public List<QuizVO> getQuizList(QuizVO quizVO) {
		return mapper.getQuizList(quizVO);
	}

	@Override
	public void insertQuiz(QuizVO quizVO) {
		mapper.insertQuiz(quizVO);
	}

	@Override
	public void updateQuiz(QuizVO quizVO) {
		mapper.updateQuiz(quizVO);
	}
	
	@Override
	public void deleteQuiz(QuizVO quizVO) {
		mapper.deleteQuiz(quizVO);
	}
}
