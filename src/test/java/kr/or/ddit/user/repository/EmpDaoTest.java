package kr.or.ddit.user.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.EmpVo;

public class EmpDaoTest {

	// 테이블의 전체 데이터(행) 조회
	@Test
	public void selectAllEmpTest() {
		/*** Given ***/
		EmpDaoI empDao = new EmpDao();

		/*** When ***/
		List<EmpVo> empList = empDao.selectAllEmp();

		/*** Then ***/
		assertEquals(14, empList.size());

	}

	// 사용자 아이디를 이용하여 특정 사용자 정보 조회
	@Test
	public void selectOneEmpTest() {
		/*** Given ***/
		EmpDaoI empDao = new EmpDao();
		int empid = 7369;

		/*** When ***/
		EmpVo empone = empDao.selectOneEmp(empid);
		/*** Then ***/
		assertEquals("SMITH", empone.getEname());
	}

	// 사용자 페이징 조회
	@Test
	public void selectPagingEmpTest() {
		/*** Given ***/
		EmpDaoI empDao = new EmpDao();
		PageVo pageVo = new PageVo(2, 5);

		/*** When ***/
		// List<PageVo> pageList = userDao.selectPagingUser(page, pageSize);
		// List<UserVo> userList = userDao.selectPagingUser(page, pageSize);

		List<EmpVo> empList = empDao.selectPagingEmp(pageVo);

		/*** Then ***/
		assertEquals(14, empList.size());

	}

}
