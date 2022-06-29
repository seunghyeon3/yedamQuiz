package com.yedam.quiz.quiz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.quiz.comm.StringUtil;
import com.yedam.quiz.quiz.mapper.QuizMapper;
import com.yedam.quiz.quiz.mapper.SectionMapper;
import com.yedam.quiz.quiz.service.QuizService;
import com.yedam.quiz.quiz.service.QuizVO;
import com.yedam.quiz.quiz.service.SectionVO;

@Service
public class QuizServiceImpl implements QuizService{

	@Autowired QuizMapper mapper;
	@Autowired SectionMapper sectionMapper;
	
	@Override
	public QuizVO getQuiz(QuizVO quizVO) {
		//문제조회
		QuizVO result = mapper.getQuiz(quizVO);
		//보기조회
		result.setSections(sectionMapper.getSectionList(quizVO.getQuizNo()));
		return result;
	}

	@Override
	public List<QuizVO> getQuizList(QuizVO quizVO) {
		List<QuizVO> list = mapper.getQuizList(quizVO);
		//줄임말 : 태그를 빼고 정해진 길이만큼만
		for(QuizVO vo : list) {
			vo.setQuizCtnt(StringUtil.abbr(vo.getQuizCtnt(), 20));
		}
		return list;
	}

	@Override
	public void insertQuiz(QuizVO quizVO) {
		//문제 등록
		mapper.insertQuiz(quizVO);
		
		//보기 등록
		List<SectionVO> sections = quizVO.getSections();
		int i=1;
		for(SectionVO section : sections) {
			section.setQuizNo(quizVO.getQuizNo());
			section.setOrd(String.valueOf(i));
			sectionMapper.insertSection(section);
			i++;
		}
	}

	@Override
	public void updateQuiz(QuizVO quizVO) {
		mapper.updateQuiz(quizVO);
	}
	
	@Override
	public void deleteQuiz(QuizVO quizVO) {
		//보기 삭제
		sectionMapper.deleteSectionByQuizNo(quizVO.getQuizNo());
		//문제 삭제
		mapper.deleteQuiz(quizVO);
	}
	
	public int getCount(QuizVO quizVO) {
		return mapper.getCount(quizVO);
	}
}
