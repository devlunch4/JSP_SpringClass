package kr.or.ddit.user.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public class UserDaoTest {

	// 테이블의 전체 데이터(행) 조회
	@Test
	public void selectUserAllTest() {
		/*** Given ***/
		UserDaoI userDao = new UserDao();

		/*** When ***/
		List<UserVo> userList = userDao.selectAllUser();

		/*** Then ***/
		assertEquals(16, userList.size());

	}

	// 사용자 아이디를 이용하여 특정 사용자 정보 조회
	@Test
	public void selectUserTest() {
		/*** Given ***/
		UserDaoI userDao = new UserDao();
		String userid = "brown";

		/*** When ***/
		UserVo user = userDao.selectUser(userid);
		/*** Then ***/
		assertNotNull(user);
		assertEquals("브라운", user.getUsernm());
	}
	
	
	//사용자 페이징 조회
	@Test
	public void selectPagingUserTest() {
		/*** Given ***/
		UserDaoI userDao = new UserDao();
		PageVo pageVo = new PageVo(2,5);
				
		
		/*** When ***/
		//List<PageVo> pageList = userDao.selectPagingUser(page, pageSize);
		//List<UserVo> userList = userDao.selectPagingUser(page, pageSize);
		
		List<UserVo> userList = userDao.selectPagingUser(pageVo);
		
		/*** Then ***/
		assertEquals(16, userList.size());
		
	}

}