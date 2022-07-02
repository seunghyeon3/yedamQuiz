package com.yedam.quiz.statics.service;

import java.util.Date;

import com.yedam.quiz.comm.service.SearchVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class StaticsVO extends SearchVO {
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

}
