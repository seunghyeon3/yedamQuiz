package com.yedam.quiz.comm.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/*
 * 작성자 : 이창호
 * 작성일자 : 2022-07-01 
 * 문제별 통계정보 : 문제별 통계 데이터.
 */
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.quiz.comm.service.CourseService;
import com.yedam.quiz.comm.service.CorsVO;

@Controller
public class CourseController {

	@Autowired
	CourseService service;

	@RequestMapping("getCourse/{corsNo}")
	public String getCourse(@PathVariable String corsNo, Model model, CorsVO courseVO) {
		courseVO.setCorsNo(corsNo);
		model.addAttribute("course", service.getCourse(courseVO));
		return "course/getCourse";
	}

	@RequestMapping("courseList")
	public String courseList(Model model, CorsVO courseVO) {
		model.addAttribute("courseList", service.getCourseList(courseVO));
		return "course/courseList";
	}

	@GetMapping("registerCourse")
	public String registerCourseForm(Model model, CorsVO courseVO) {
		// service.insertCourse(courseVO);
		Map<String, String> basic = new HashMap<>();
		basic.put("id", "hong");
		basic.put("name", "kildong");
		basic.put("pass", "1234");

		model.addAttribute("basic", basic);
		return "course/insertCourse";
	}

	@PostMapping("registerCourse")
	public String registerCourse(CorsVO courseVO) {
		System.out.println(courseVO);
		service.insertCourse(courseVO);
		return "course/getCourseList";
	}
}
