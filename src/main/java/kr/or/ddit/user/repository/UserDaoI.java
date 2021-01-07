package kr.or.ddit.user.repository;

import java.util.List;

import kr.or.ddit.user.model.UserVo;

public interface UserDaoI {

	//전체 사용자 정보 조회
	//SELECT * 
	//FROM users;
	
	//public 필요가 없음. 자동으로 붙음.
	
	
	//반환타입 메소드명();
	List<UserVo> selectAllUser();
	
}
