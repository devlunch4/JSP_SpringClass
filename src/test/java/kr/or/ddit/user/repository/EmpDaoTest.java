package kr.or.ddit.user.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.emp.model.EmpVo;
import kr.or.ddit.emp.repository.EmpDao;
import kr.or.ddit.emp.repository.EmpDaoI;

public class EmpDaoTest {
	private EmpDaoI empDao;
	
	@Before
	public void setup() {
		
	}
	
	@After
	public void tearDown() {
		empDao.deleteEmp(123);
	}

	// EMP 전체 데이터(행) 조회
	@Test
	public void selectAllEmpTest() {
		/*** Given ***/
		EmpDaoI empDao = new EmpDao();

		/*** When ***/
		List<EmpVo> empList = empDao.selectAllEmp();

		/*** Then ***/
		assertEquals(14, empList.size());

	}

	// EMP 아이디를 이용하여 특정 사용자 정보 조회
	@Test
	public void selectOneEmpTest() {
		/*** Given ***/
		EmpDaoI empDao = new EmpDao();
		int empno = 7369;

		/*** When ***/
		EmpVo empone = empDao.selectOneEmp(empno);
		/*** Then ***/
		assertEquals("SMITH", empone.getEname());
	}

	// EMP 페이징 조회
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
	
	
	// EMP 전체 수 조회
	@Test
	public void selectAllEmpCntTest() {
		/***Given***/
		//setup

		/***When***/

		/***Then***/
	}

}
