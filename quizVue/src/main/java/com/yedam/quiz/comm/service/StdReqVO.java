package com.yedam.quiz.comm.service;


import java.util.List;
import lombok.Data;

@Data
public class StdReqVO {
	private List<String> stdNo;
	private String useYn;
}
