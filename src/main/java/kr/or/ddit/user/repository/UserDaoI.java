package kr.or.ddit.user.repository;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface UserDaoI {

	// 전체 사용자 정보 조회
	// SELECT *
	// FROM users;

	// public 필요가 없음. 자동으로 붙음.

	// 반환타입 메소드명();
	List<UserVo> selectAllUser();

	// userid에 해당하는 사용자 한명의 정보 조회
	UserVo selectUser(String userid);

	//페이지 처리 
	List<UserVo> selectPagingUser(PageVo pageVo);
	
	//사용자 전체수 조회
	int selectAllUserCnt();
	
	//사용자 정보 수정
	int modifyUser(UserVo userVo);
	
	//사용자 정보 추가
	int insertUser(UserVo userVo);
	
	//사용자 삭제
	int deleteUser(String userid);
}
