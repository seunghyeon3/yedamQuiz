package com.yedam.quiz.comm.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yedam.quiz.comm.ExcelUtil;
import com.yedam.quiz.comm.mapper.StdMapper;
import com.yedam.quiz.comm.service.StdReqVO;
import com.yedam.quiz.comm.service.StdService;
import com.yedam.quiz.comm.service.StdVO;

@Service
public class StdServiceImpl implements StdService {

	@Autowired
	StdMapper map;
	@Autowired
	ExcelUtil excelUtil;
	
	@Override
	public StdVO getStudent(StdVO vo) {		
		return map.getStudent(vo);
	}

	@Override
	public List<StdVO> getStudentList(StdVO vo) {
		return map.getStudentList(vo);
	}

	@Override
	public void insertStudent(StdVO vo) {
		//학생번호조회
		String stdNo = map.getStdNo(vo);
		vo.setStdNo(stdNo);
		map.insertStudent(vo);
	}	

	@Override
	public void updateStudent(StdVO vo) {
		map.updateStudent(vo);
	}

	@Override
	public void deleteStudent(StdVO vo) {
		map.deleteStudent(vo);
	}

	public int getCount(StdVO vo) {
		return map.getCount(vo);
	}
	
	//선택된 학생들의 사용여부 일괄 변경
	@Override
	public int updateUseYn(StdReqVO vo) {
		return map.updateUseYn(vo);
	}

	//일괄등록(엑셀업로드)
	@Override
	public Map<String, Object> batchReg(MultipartFile file, StdVO vo) {
		Map<String, Object> res = new HashMap<String, Object>();

		// 파일 존재하지 않는 경우
		if (file.isEmpty() || file.getSize()==0) {
			res.put("result",false);
			res.put("msg","Excel 파일을 선택해주세요.");
			return res;
		}

		// 확장자 유효성 검사 -> 엑셀파일만 가능
		int idx = file.getOriginalFilename().indexOf(".") ;
		String ext = file.getOriginalFilename().substring(idx) ;//fileUtil.getExtension(file.getOriginalFilename());

		if (!ext.equals("xlsx") && !ext.equals("xls")) {
			res.put("result",false);
			res.put("msg","Excel 파일을 선택해주세요.");
			return res;
		}

		//학생번호조회
		int stdNo = Integer.parseInt(map.getStdNo(vo));
		List<StdVO> listUser = new ArrayList<StdVO>();

		// 엑셀의 셀데이터를 가져와서 VO에 담기
		List<Map<String, Object>> listMap = excelUtil.getListData(file, 1, 3);
		for (Map<String, Object> map : listMap) {
			StdVO userInfo = new StdVO();
		
			// 각 셀의 데이터를 VO에 set한다.
			userInfo.setStdNo(String.valueOf(stdNo++));
			userInfo.setLtRoom(map.get("1").toString());
			userInfo.setStdNm(map.get("2").toString());
			userInfo.setCorsNo(vo.getCorsNo());

			listUser.add(userInfo);
		}

		// 리스트에 담은 VO를 DB에 저장
		for (StdVO oneUser : listUser){
			map.insertStudent(oneUser);
		}
		res.put("result",true);
		res.put("cnt", listUser.size());
		
		//업로드파일삭제
		//new File(file.getOriginalFilename()).delete();
		return res;
	}

}
