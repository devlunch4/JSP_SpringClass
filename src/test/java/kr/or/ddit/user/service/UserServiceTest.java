package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public class UserServiceTest {
	// 테이블의 전체 데이터(행) 조회
	@Test
	public void selectUserAllTest() {
		/*** Given ***/
		UserServiceI userDao = new UserService();

		/*** When ***/
		List<UserVo> userList = userDao.selectAllUser();

		/*** Then ***/
		assertEquals(16, userList.size());

	}

	// 사용자 아이디를 이용하여 특정 사용자 정보 조회
	@Test
	public void selectUserTest() {
		/*** Given ***/
		UserServiceI userDao = new UserService();
		String userid = "brown";

		/*** When ***/
		UserVo user = userDao.selectUser(userid);

		/*** Then ***/
		assertNotNull(user);
		assertEquals("브라운", user.getUsernm());
	}

	// 사용자 아이디가 존재하지 않을떄 특정 사용자 조회 (확신이 없을때 확인을 위한 테스트 )
	@Test
	public void selectUserNotExsistTest() {
		/*** Given ***/
		UserServiceI userDao = new UserService();
		String userid = "brown";

		/*** When ***/
		UserVo user = userDao.selectUser(userid);

		/*** Then ***/
		assertNotNull(user);
		//assertEquals("브라운", user.getUserid());
	}

	// 사용자 페이징 조회
	@Test
	public void selectPagingUserTest() {
		/*** Given ***/
		UserServiceI userDao = new UserService();
		PageVo pageVo = new PageVo(2, 5);

		/*** When ***/
		// List<PageVo> pageList = userDao.selectPagingUser(page, pageSize);
		// List<UserVo> userList = userDao.selectPagingUser(page, pageSize);

		Map<String, Object> userList = userDao.selectPagingUser(pageVo);

		/*** Then ***/
		assertEquals(2, userList.size());
	}
}
