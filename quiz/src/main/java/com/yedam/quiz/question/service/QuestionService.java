package com.yedam.quiz.question.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionService {

	public QuestionVO getQuestion(QuestionVO vo);
	public List<QuestionVO> getQuestionList();
	public void insertQuestion(QuestionVO vo);
	public void updateQuestion(QuestionVO vo);
	public void deleteQuestion(QuestionVO vo);
}