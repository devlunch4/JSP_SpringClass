package kr.or.ddit.emp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.emp.model.EmpVo;
import kr.or.ddit.emp.repository.EmpDao;
import kr.or.ddit.emp.repository.EmpDaoI;

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

	@Override
	public int updateEmp(EmpVo empVo) {
		return empDao.updateEmp(empVo);
	}

	@Override
	public int insertEmp(EmpVo empVo) {
		return empDao.insertEmp(empVo);
	}

	@Override
	public int deleteEmp(int empno) {
		return empDao.deleteEmp(empno);
	}
}