package com.yedam.quiz.comm.service;

import java.util.List;

import lombok.Data;
@Data
public class GridData<T> {
	private List<T> updatedRows;
	private List<T> deletedRows;
	private List<T> createdRows;
}
