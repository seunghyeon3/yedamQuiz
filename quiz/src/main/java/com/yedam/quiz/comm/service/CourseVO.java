package com.yedam.quiz.comm.service;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseVO extends SearchVO {
	private String corsNo;
	private String corsNm;
	private String sdt;
	private String edt;
	private String ltRoom;
	private String useYn;
}
