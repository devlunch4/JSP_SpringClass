package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Map<String, Object> selectPagingEmp(PageVo pageVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<EmpVo> empList = empDao.selectPagingEmp(pageVo);
		int empCnt = empDao.selectAllEmpCnt();
		map.put("empList", empList);
		map.put("empCnt", empCnt);
		return map;
	}

}