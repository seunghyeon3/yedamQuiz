package com.yedam.quiz.quiz.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SectionService {
    public SectionVO getSection(SectionVO sectionVO);
    public List<SectionVO> getSectionList(String quizNo);
    public void insertSection(SectionVO sectionVO);
    public void updateSection(SectionVO sectionVO);
    public void deleteSection(SectionVO sectionVO);
    public void deleteSectionByQuizNo(String quizNo);
}
