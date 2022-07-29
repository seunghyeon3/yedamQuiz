package com.yedam.quiz.comm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.yedam.quiz.comm.service.CodeService;

@Controller
public class CodeController {

	@Autowired CodeService codeService;

}
