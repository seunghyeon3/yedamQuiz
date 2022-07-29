package com.yedam.quiz.comm.service;


import java.sql.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class StdVO extends SearchVO{
	private String stdNo;		//학생번호   yyyyMMdd0101
	private String stdNm;		//학생명
	private String useYn;		//사용여부
	private String year;		//출생년도
	private String corsNo;		//과정코드
	private String corsNm;		//과정명
	private String ltRoom;		//강의실
	private Date sdt;			//과정시작일
	private Date edt;			//과정종료일
}
