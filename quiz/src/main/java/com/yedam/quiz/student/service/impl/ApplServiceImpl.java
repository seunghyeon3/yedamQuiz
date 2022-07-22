package com.yedam.quiz.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.quiz.student.mapper.ApplMapper;
import com.yedam.quiz.student.service.ApplService;
import com.yedam.quiz.student.service.ApplVO;

@Service
public class ApplServiceImpl implements ApplService {

	@Autowired
	ApplMapper map;
	
	@Override
	public List<ApplVO> getApplList(ApplVO applVO) {
		// TODO Auto-generated method stub
		return map.getApplList(applVO);
	}

	@Override
	public ApplVO getAppl(ApplVO applVO) {
		// TODO Auto-generated method stub
		return map.getAppl(applVO);
	}

	@Override
	public void insertAppl(ApplVO applVO) {
		// TODO Auto-generated method stub
		map.insertAppl(applVO);
	}

	@Override
	public void updateAppl(ApplVO applVO) {
		// TODO Auto-generated method stub
		map.updateAppl(applVO);
	}

	@Override
	public void deleteAppl(ApplVO applVO) {
		// TODO Auto-generated method stub
		map.deleteAppl(applVO);
	}

	@Override
	public void getExamResult(ApplVO applVO) {
		map.getExamResult(applVO);		
	}

}
