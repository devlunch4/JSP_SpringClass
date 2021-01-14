package kr.or.ddit.emp.repository;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.emp.model.EmpVo;

public interface EmpDaoI {

	// 전체 EMP 조회
	List<EmpVo> selectAllEmp();

	// 한명의 EMP 정보 조회
	EmpVo selectOneEmp(int empno);

	// 페이지 처리
	List<EmpVo> selectPagingEmp(PageVo pageVo);

	// EMP 전체수 조회
	int selectAllEmpCnt();
	
	// EMP 정보 수정
	int updateEmp(EmpVo empvo);

	//EMP 정보 추가
	int insertEmp(EmpVo empvo);
	
	//EMP 정보 삭제
	int deleteEmp(int empno);
}
