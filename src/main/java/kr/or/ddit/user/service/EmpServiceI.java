package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.EmpVo;

public interface EmpServiceI {

	// 전체 EMP 조회
	List<EmpVo> selectAllEmp();

	// 한명의 EMP 정보 조회
	EmpVo selectOneEmp(int empno);

	// 페이지 처리
	Map<String, Object> selectPagingEmp(PageVo pagevo);

}
