package com.yedam.quiz.exam.service;

import java.sql.Date;

import lombok.Data;

@Data
public class CoruseVO {
	private String corsNo;
	private String corsNm;
	private Date sdt;
	private Date edt;
	private char ltRoom;
	private String useYn;
	private StudentVO vo;
}
