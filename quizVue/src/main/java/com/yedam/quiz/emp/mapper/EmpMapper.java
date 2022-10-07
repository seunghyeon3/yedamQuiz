package com.yedam.quiz.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.quiz.emp.service.EmpVO;

@Mapper
public interface EmpMapper {
    public EmpVO getEmp(EmpVO empVO);
    public List<EmpVO> getEmpList(EmpVO empVO);
    public void empInsert(EmpVO empVO);
    public void empUpdate(EmpVO empVO);
}
