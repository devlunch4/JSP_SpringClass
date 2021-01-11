package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.user.model.EmpVo;

public class EmpServiceTest {
	// 테이블의 전체 데이터(행) 조회
	@Test
	public void selectAllEmpTest() {
		/*** Given ***/
		EmpServiceI empDao = new EmpService();

		/*** When ***/
		List<EmpVo> empList = empDao.selectAllEmp();

		/*** Then ***/
		assertEquals(14, empList.size());
	}

	// 사용자 아이디를 이용하여 특정 사용자 정보 조회
	@Test
	public void selectOneEmpTest() {
		/*** Given ***/
		EmpServiceI empDao = new EmpService();
		int empid = 7369;

		/*** When ***/
		EmpVo user = empDao.selectOneEmp(empid);

		/*** Then ***/
		assertNotNull(user);
		assertEquals("SMITH", user.getEname());
	}

	// 사용자 EMP 페이징 조회
	// @Test
//	public void selectPagingEmpTest() {
	/*** Given ***/
//		EmpServiceI empDao = new EmpService();
//		PageVo pageVo = new PageVo(2, 5);

	/*** When ***/
	// List<PageVo> pageList = empDao.selectPagingUser(page, pageSize);
	// List<UserVo> empList = empDao.selectPagingUser(page, pageSize);

	// kr.or.ddit.etc 패키지 paginationTest.java 구현됨.
	// List<EmpVo> empList = empDao.selectPagingEmp(pageVo);

	/*** Then ***/
	// assertEquals(16, empList.size());
//	}
}
