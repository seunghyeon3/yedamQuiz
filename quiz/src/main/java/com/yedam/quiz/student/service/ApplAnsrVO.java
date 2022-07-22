package com.yedam.quiz.student.service;

import java.util.List;

import lombok.Data;

@Data
public class ApplAnsrVO {
	private int quizNo;
	private int examNo;
	private String stdNo;
	private int ord;
	private String ansr;
	private int scor;
	private char ansrYn;
	
	private List<ApplAnsrVO> ansrlist;
}
