package com.yedam.quiz.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.quiz.exam.service.QuestionVO;

@Mapper
public interface QuestionMapper {
	public List<QuestionVO> getQuestionList(QuestionVO guestionVO);
	public QuestionVO getQuestin(QuestionVO guestionVO);
	public void insertQuestion(QuestionVO guestionVO);
	public void updqteQuestion(QuestionVO guestionVO);
	public void deleteQuestion(QuestionVO guestionVO);
	
}
