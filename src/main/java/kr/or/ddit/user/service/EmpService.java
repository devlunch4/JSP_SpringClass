package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.EmpVo;
import kr.or.ddit.user.repository.EmpDao;
import kr.or.ddit.user.repository.EmpDaoI;

public class EmpService implements EmpServiceI {
	private EmpDaoI empDao = new EmpDao();

	@Override
	public List<EmpVo> selectAllEmp() {
		return empDao.selectAllEmp();
	}

	@Override
	public EmpVo selectOneEmp(int empno) {
		return empDao.selectOneEmp(empno);
	}

	@Override
	public List<EmpVo> selectPagingEmp(PageVo pagevo) {
		return empDao.selectPagingEmp(pagevo);
	}

}