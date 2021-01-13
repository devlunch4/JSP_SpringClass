package kr.or.ddit.user.repository;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.EmpVo;

public interface EmpDaoI {

	// 전체 EMP 조회
	List<EmpVo> selectAllEmp();

	// 한명의 EMP 정보 조회
	EmpVo selectOneEmp(int empno);

	// 페이지 처리
	List<EmpVo> selectPagingEmp(PageVo pageVo);

	// EMP 전체수 조회
	int selectAllEmpCnt();

}
