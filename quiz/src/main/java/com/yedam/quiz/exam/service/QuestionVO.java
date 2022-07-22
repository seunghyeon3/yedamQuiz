package com.yedam.quiz.exam.service;

import lombok.Data;

@Data
public class QuestionVO {
	private int examNo;
	private int quizNo;
	private String quizCtnt;
	private String typCd;
	private String ansr;
	private int qestnOrd;
	private int qestnScor;

}
