package com.yedam.quiz.quiz.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.quiz.exam.service.QuestionVO;
import com.yedam.quiz.quiz.mapper.SectionMapper;
import com.yedam.quiz.quiz.service.SectionService;
import com.yedam.quiz.quiz.service.SectionVO;

@Service
public class SectionServiceImpl implements SectionService{

	@Autowired SectionMapper mapper;
	
	@Override
	public SectionVO getSection(SectionVO sectionVO) {
		return mapper.getSection(sectionVO);
	}

	@Override
	public List<SectionVO> getSectionList(String quizNo) {
		List<SectionVO> list = mapper.getSectionList(quizNo);
		return list;
	}

	@Override
	public void insertSection(SectionVO sectionVO) {
		mapper.insertSection(sectionVO);
	}

	@Override
	public void updateSection(SectionVO sectionVO) {
		mapper.updateSection(sectionVO);
	}
	
	@Override
	public void deleteSection(SectionVO sectionVO) {
		mapper.deleteSection(sectionVO);
	}

	@Override
	public void deleteSectionByQuizNo(String quizNo) {
		mapper.deleteSectionByQuizNo(quizNo);
	}

	@Override
	public Map<Integer, List<SectionVO>> getSectionPerQuiz(List<QuestionVO> qList) {
		Map<Integer, List<SectionVO>> map = new HashMap<>();
		for(QuestionVO question : qList) {
			int quizNo = question.getQuizNo();
			List<SectionVO> sList = mapper.getSectionList(String.valueOf(quizNo));
			map.put(quizNo, sList);
		}
		
		return map;
	}	
}
