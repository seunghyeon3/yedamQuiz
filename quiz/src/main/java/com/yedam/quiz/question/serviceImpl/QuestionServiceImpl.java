package com.yedam.quiz.question.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.quiz.question.mapper.QuestionMapper;
import com.yedam.quiz.question.service.QuestionService;
import com.yedam.quiz.question.service.QuestionVO;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	QuestionMapper map;
	
	@Override
	public QuestionVO getQuestion(QuestionVO vo) {
		return map.getQuestion(vo);
	}

	@Override
	public List<QuestionVO> getQuestionList() {
		return map.getQuestionList();
	}

	@Override
	public void insertQuestion(QuestionVO vo) {
		map.insertQuestion(vo);
	}

	@Override
	public void updateQuestion(QuestionVO vo) {
		map.updateQuestion(vo);
	}

	@Override
	public void deleteQuestion(QuestionVO vo) {
		map.deleteQuestion(vo);		
	}
	

}
