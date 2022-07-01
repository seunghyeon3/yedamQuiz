package com.yedam.quiz.quiz.service;


import java.util.List;
import lombok.Data;

@Data
public class QuizReqVO {
	private List<String> quizNo;
	private String useYn;
}
