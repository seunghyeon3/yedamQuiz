package com.yedam.quiz.quiz.service;

import java.util.Date;
import java.util.List;

import com.yedam.quiz.comm.service.SearchVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class QuizVO extends SearchVO {
	private String quizNo;		//문제번호
	private String sbjtCd;		//과목코드
	private String sbjtNm;		//과목명
	private String quizCtnt;	//문제
	private String typCd;		//문제유형코드
	private String typNm;		//문제유형명
	private String ansr;		//정답
	private String desct;		//문제해설
	private String useYn;		//사용여부
	private String questCnt;	//출제수
	private String rightRate;   //정답율
	private Date   regDt;		//등록일자
	private String regName;		//등록자  -- 추가할것
	
	private List<SectionVO> sections;  //보기 리스트
}
