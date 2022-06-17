package com.yedam.quiz.quiz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.quiz.comm.StringUtil;
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
		List<QuizVO> list = mapper.getQuizList(quizVO);
		//줄임말 : 태그를 빼고 정해진 길이만큼만
		for(QuizVO vo : list) {
			vo.setQuizCtnt(StringUtil.abbr(vo.getQuizCtnt(), 20));
		}
		return list;
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
	
	public int getCount(QuizVO quizVO) {
		return mapper.getCount(quizVO);
	}
}
