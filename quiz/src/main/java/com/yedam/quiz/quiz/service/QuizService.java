package com.yedam.quiz.quiz.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.quiz.quiz.service.QuizVO;

@Mapper
public interface QuizService {
    public QuizVO getQuiz(QuizVO quizVO);
    public List<QuizVO> getQuizList(QuizVO quizVO);
    public void insertQuiz(QuizVO quizVO);
    public void updateQuiz(QuizVO quizVO);
    public void deleteQuiz(QuizVO quizVO);
    public int getCount(QuizVO quizVO);
    public int updateUseYn(QuizReqVO vo);
}
