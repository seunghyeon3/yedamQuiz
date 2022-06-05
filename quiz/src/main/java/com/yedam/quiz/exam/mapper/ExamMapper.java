package com.yedam.quiz.exam.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.yedam.quiz.exam.service.ExamVO;

@Mapper
public interface ExamMapper {
	
	public ExamVO getExam(ExamVO vo);
	public List<ExamVO> getExamList();
	public void insertExam(ExamVO vo);
	public void updateExam(ExamVO vo);
	public void deleteExam(ExamVO vo);
	
}
