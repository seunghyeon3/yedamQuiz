package com.yedam.quiz;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.quiz.quiz.mapper.QuizMapper;
import com.yedam.quiz.quiz.service.QuizVO;

@SpringBootTest
public class QuizMapperTest {

	@Autowired
	QuizMapper mapper;

	@Test
	public void list() {
		List<QuizVO> list = mapper.getQuizList(null);
		System.out.println("==================================");

		System.out.println(list);
	}
}
