package com.yedam.quiz.student.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.quiz.exam.mapper.QuestionMapper;
import com.yedam.quiz.exam.service.QuestionVO;
import com.yedam.quiz.quiz.mapper.QuizMapper;
import com.yedam.quiz.quiz.service.QuizVO;
import com.yedam.quiz.student.mapper.ApplAnsrMapper;
import com.yedam.quiz.student.mapper.ApplMapper;
import com.yedam.quiz.student.service.ApplAnsrService;
import com.yedam.quiz.student.service.ApplAnsrVO;
import com.yedam.quiz.student.service.ApplVO;

@Service
public class ApplAnsrServiceImpl implements ApplAnsrService {

	@Autowired
	ApplAnsrMapper map;
	
	@Autowired
	QuizMapper qzMap;
	
	@Autowired
	QuestionMapper qeMap;
	
	@Autowired
	ApplMapper applMap;
	
	@Override
	public List<ApplAnsrVO> getApplAnsrList(ApplAnsrVO applAnsrVO) {
		return map.getApplAnsrList(applAnsrVO);
	}

	@Override
	public ApplAnsrVO getApplAnsr(ApplAnsrVO applAnsrVO) {
		return map.getApplAnsr(applAnsrVO);
	}

	@Override
	public void insertApplAnsr(ApplAnsrVO applAnsrVO) {
		map.insertApplAnsr(applAnsrVO);
		
	}

	@Override
	public void updateApplAnsr(ApplAnsrVO applAnsrVO) {
		map.updateApplAnsr(applAnsrVO);
	}

	@Override
	public void deleteApplAnsr(ApplAnsrVO applAnsrVO) {
		map.deleteApplAnsr(applAnsrVO);
	}

	@Override
	@Transactional
	public void insertApplAnsrList(List<ApplAnsrVO> ansrList) {
		
		for(ApplAnsrVO ansrVO : ansrList) {
			//문제은행 정보
			QuizVO qzVO = new QuizVO();
			qzVO.setQuizNo(String.valueOf(ansrVO.getQuizNo()));
			qzVO = qzMap.getQuiz(qzVO);
			
			//시험문제 정보
			QuestionVO qeVO = new QuestionVO();
			qeVO.setExamNo(ansrVO.getExamNo());
			qeVO.setQuizNo(ansrVO.getQuizNo());
			qeVO = qeMap.getQuestin(qeVO);
			
			ansrVO.setOrd(qeVO.getQestnOrd());
			ansrVO.setScor(qeVO.getQestnScor());
			ansrVO.setAnsrYn(ansrVO.getAnsr().equals(qzVO.getAnsr())? '1' : '0');
						
			insertApplAnsr(ansrVO);
		}
		
		ApplVO applVO = new ApplVO();
		applVO.setExamNo(ansrList.get(0).getExamNo());
		applVO.setStdNo(ansrList.get(0).getStdNo());
		Date applDttm = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd hh:mm:ss");
		applVO.setApplDttm(sdf.format(applDttm));
		applMap.getExamResult(applVO);
	
	}
	
	

}
