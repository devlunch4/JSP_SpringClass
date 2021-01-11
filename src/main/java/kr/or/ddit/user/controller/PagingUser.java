package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

@WebServlet("/pagingUser")
public class PagingUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(PagingUser.class);
	private UserServiceI userService = new UserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// left.jsp /pagingUser?page=?=pageSize=?
		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>pagingUser

		// doGet()메소드에서 page, pageSize 파라미터가 request 객체에 존재하지 않을때
		// page 1로, pageSize 5로 생각을 코드를 작성
		// 파라미터가 존재하면 해당 파라미터를 이용

		String pageParam = req.getParameter("page");
		String pageSizeParam = req.getParameter("pagesize");
		logger.debug("초기 입력 파라미터 pageParam : {}, req.pageSize : {}", pageParam, pageSizeParam);

		// 잘못된 코드 >> 변수 생성 >. null인경우가 필요
		// int page = Integer.parseInt(req.getParameter("pagesize"));

		// request 객체에서 제공하는 파라미터 관련 메소드
		// Map<String, String> map = new HashMap<String,String>();

		// 방법1 if문 사용
		// 방법2 삼항연산자 사용
		// 방법3 refactoring 사용 : 코드를 (깔끔하게) 바꾸는데 기존 동작방식을 유지한채로 변경하는 기법

		// 삼항연산자 사용 if/else ==>?
		// 파라미터가 존재하는 경우
		int page = pageParam == null ? 1 : Integer.parseInt(pageParam);
		int pagesize = pageSizeParam == null ? 5 : Integer.parseInt(pageSizeParam);

		// if문 사용
//		if (req.getParameter("page") != null) {
//			page = Integer.parseInt(req.getParameter("page"));
//		} else {
//			page = 1;
//		}
//
//		if (req.getParameter("pagesize") != null) {
//			pagesize = Integer.parseInt(req.getParameter("pageSize"));
//		} else {
//			pagesize = 5;
//		}
		logger.debug("세팅 된 page : {}, pageSize : {}", page, pagesize);
		PageVo pagevo = new PageVo(page, pagesize);

		Map<String, Object> map = userService.selectPagingUser(pagevo);

		List<UserVo> userList = (List<UserVo>) map.get("userList");
		int userCnt = (int) map.get("userCnt");
		int pagination = (int) Math.ceil((double) userCnt / pagesize);
		logger.debug("userCnt 값 : {}, pagination 값 : {}", userCnt, pagination);
		req.setAttribute("userList", userList);
		req.setAttribute("pagination", pagination);
		logger.debug("In /pagingUser doGet() >> Forward : pagingUser.jsp //");
		req.getRequestDispatcher("/user/pagingUser.jsp").forward(req, resp);

	}

}
