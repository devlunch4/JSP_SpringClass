package kr.or.ddit.user.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.user.model.UserVo;

public class UserDao implements UserDaoI{

	@Override
	public List<UserVo> selectAllUser() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
				
		//SELECT : 리턴되는 값으 복수 유무를 판단
		//>>>>>>> 1. 단건 : 일반 객체를 반환(UserVo) selectOne()
		//>>>>>>> 1. 다건 : List<UserVo> selectList()
		// INSERT,UPDATE, DELETE : INSERT,UPDATE, DELETE
		
		//메소드 이름과 실행할 sql id를 동일하게 맞추자 (유지보수 - 다른 개발자의 가독성)
		
		//>> users.selectAllUser >> 네임스페이스.아이디
		List<UserVo> userList = sqlSession.selectList("users.selectAllUser");
		
		//자원 해제
		sqlSession.close();
		
		//dao >> service >> 화면 
		return userList;
	}

}
