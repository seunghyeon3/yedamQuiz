package com.yedam.quiz.comm.service;

import java.util.List;

import lombok.Data;
@Data
public class GridData<T> {
	private List<CodeVO> updatedRows;
	private List<CodeVO> deletedRows;
	private List<CodeVO> createdRows;
}
