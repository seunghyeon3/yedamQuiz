package com.yedam.quiz.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.quiz.exam.mapper.QuestionMapper;
import com.yedam.quiz.exam.service.QuestionService;
import com.yedam.quiz.exam.service.QuestionVO;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	QuestionMapper map;

	@Override
	public List<QuestionVO> getQuestionList(QuestionVO guestionVO) {
		// TODO Auto-generated method stub
		return map.getQuestionList(guestionVO);
	}

	@Override
	public QuestionVO getQuestin(QuestionVO guestionVO) {
		// TODO Auto-generated method stub
		return map.getQuestin(guestionVO);
	}

	@Override
	public void insertQuestion(QuestionVO guestionVO) {
		// TODO Auto-generated method stub
		map.insertQuestion(guestionVO);
	}

	@Override
	public void updqteQuestion(QuestionVO guestionVO) {
		// TODO Auto-generated method stub
		map.updqteQuestion(guestionVO);
	}

	@Override
	public void deleteQuestion(QuestionVO guestionVO) {
		// TODO Auto-generated method stub
		map.deleteQuestion(guestionVO);
	}

}
