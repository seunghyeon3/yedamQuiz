package com.yedam.quiz.quiz.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.quiz.exam.service.QuestionVO;

@Mapper
public interface SectionService {
    public SectionVO getSection(SectionVO sectionVO);
    public List<SectionVO> getSectionList(String quizNo);
    public void insertSection(SectionVO sectionVO);
    public void updateSection(SectionVO sectionVO);
    public void deleteSection(SectionVO sectionVO);
    public void deleteSectionByQuizNo(String quizNo);
    
    public Map<Integer, List<SectionVO>> getSectionPerQuiz(List<QuestionVO> qList);
}
