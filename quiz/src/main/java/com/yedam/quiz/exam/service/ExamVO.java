package com.yedam.quiz.exam.service;

import java.sql.Date;
import java.util.List;

import com.yedam.quiz.comm.service.SearchVO;
import com.yedam.quiz.student.service.StudentVO;

import lombok.Data;

@Data
public class ExamVO extends SearchVO{

	private int examNo;			//시험번호
	private String examNm;		//시험명
	private String examDesct;	//시험설명
	private String ltRoom;		//강의실
	private String sbjtCd;		//과목코드
	private Date regDt;			//등록일
	private String startDttm;	//시험시작일
	private String endDttm;		//시험종료일
	private int rcntCt;			//응시인원
	private char useYn;			//사용여부
	private String corsNo;		//과정번호
	private int orgNo;			//원본시험지번호
	private int ttScor;			//총점
	
	private List<StudentVO> std;
	private List<QuestionVO> qstn;
	
	
}
