package com.yedam.quiz.quiz.mapper;

import java.util.List;

import com.yedam.quiz.quiz.service.SectionVO;

public interface SectionMapper {
    public SectionVO getSection(SectionVO sectionVO);
    public List<SectionVO> getSectionList(String quizNo);
    public void insertSection(SectionVO sectionVO);
    public void updateSection(SectionVO sectionVO);
    public void deleteSection(SectionVO sectionVO);
    public void deleteSectionByQuizNo(String quizNo);
}
