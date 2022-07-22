package com.yedam.quiz.appl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.quiz.appl.mapper.ApplMapper;
import com.yedam.quiz.appl.service.ApplService;
import com.yedam.quiz.appl.service.ApplVO;

@Service
public class ApplServiceImpl implements ApplService{

	@Autowired
	ApplMapper map;

	@Override
	public ApplVO getAppl(ApplVO vo) {
		return map.getAppl(vo);
	}

	@Override
	public List<ApplVO> getApplList() {
		return map.getApplList();
	}

	@Override
	public void insertAppl(ApplVO vo) {
		map.insertAppl(vo);
	}

	@Override
	public void updateAppl(ApplVO vo) {
		map.updateAppl(vo);
	}

	@Override
	public void deleteAppl(ApplVO vo) {
		map.deleteAppl(vo);
	}

	@Override
	public void firstInsertAppl(int examNo, String stdNo) {
		map.firstInsertAppl(examNo, stdNo);
	}

}
