package kr.or.ddit.emp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.emp.model.EmpVo;

public class EmpDao implements EmpDaoI {

	@Override
	public List<EmpVo> selectAllEmp() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<EmpVo> empList = sqlSession.selectList("emp.selectAllEmp");
		sqlSession.close();
		return empList;
	}

	@Override
	public EmpVo selectOneEmp(int empno) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		EmpVo emp = sqlSession.selectOne("emp.selectOneEmp", empno);
		sqlSession.close();
		return emp;
	}

	@Override
	public List<EmpVo> selectPagingEmp(PageVo pageVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<EmpVo> empList = sqlSession.selectList("emp.selectPagingEmp", pageVo);
		sqlSession.close();
		return empList;
	}

	@Override
	public int selectAllEmpCnt() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int empCnt = sqlSession.selectOne("emp.selectAllEmpCnt");
		// SELECT COUNT(*) FROM emp
		sqlSession.close();
		return empCnt;
	}

	@Override
	public int updateEmp(EmpVo empvo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int updateCnt = sqlSession.update("emp.updateEmp", empvo);
		if (updateCnt == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return updateCnt;
	}

	@Override
	public int insertEmp(EmpVo empvo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int insertCnt = sqlSession.update("emp.insertEmp", empvo);
		if (insertCnt == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return insertCnt;
	}

	@Override
	public int deleteEmp(int empno) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int deleteCnt = sqlSession.delete("emp.deleteEmp", empno);
		if (deleteCnt == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return deleteCnt;
	}
}
