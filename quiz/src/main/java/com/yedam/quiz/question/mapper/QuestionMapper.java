package com.yedam.quiz.question.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.quiz.question.service.QuestionVO;

@Mapper
public interface QuestionMapper {

	public QuestionVO getQuestion(QuestionVO vo);
	public List<QuestionVO> getQuestionList();
	public void insertQuestion(QuestionVO vo);
	public void updateQuestion(QuestionVO vo);
	public void deleteQuestion(QuestionVO vo);
}
