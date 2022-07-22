package com.yedam.quiz.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface QuestionService {
	public List<QuestionVO> getQuestionList(QuestionVO guestionVO);
	public QuestionVO getQuestin(QuestionVO guestionVO);
	public void insertQuestion(QuestionVO guestionVO);
	public void updqteQuestion(QuestionVO guestionVO);
	public void deleteQuestion(QuestionVO guestionVO);
	
}
