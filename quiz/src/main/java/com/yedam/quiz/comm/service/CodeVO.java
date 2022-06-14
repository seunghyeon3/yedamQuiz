package com.yedam.quiz.comm.service;

import lombok.Data;

@Data
public class CodeVO {
	private String cd;
	private String nm;
	private String gpCd;
	private String useUn;
	
	//그룹코드 초기화
	public CodeVO(String gpCd) {
		this.gpCd = gpCd;
	}
}
