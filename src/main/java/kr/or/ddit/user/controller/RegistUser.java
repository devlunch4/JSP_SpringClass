package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

@WebServlet("/registUser")
public class RegistUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(RegistUser.class);
	private UserServiceI userService = new UserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("registUser doGet() 진입");
		req.getRequestDispatcher("/user/registUser.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("registUser doPost() 진입");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		// 입력 값 가져오기
		// 값 가져오기
		String userid = req.getParameter("userId");
		String userNm = req.getParameter("userNm");
		String pass = req.getParameter("pass");

		// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		// String reg_dt = null;
		Date reg_dt_fm = new Date();
//		try {
//			reg_dt_fm = dateFormat.parse(reg_dt);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}

		String userAlias = req.getParameter("userAlias");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String zipcode = req.getParameter("zipcode");
		logger.debug("입력값들 중 id 확인 userid : {}", userid);
		UserVo userVo = new UserVo(userid, userNm, pass, reg_dt_fm, userAlias, addr1, addr2, zipcode);
//		try {
//			int insertUser = userService.insertUser(userVo);
//			if (insertUser == 1) {
//				// 정상수행
//				logger.debug("registUser doPost() try 정상수행 >> /user?userid={} 이동",userid);
//				resp.sendRedirect(req.getContextPath() + "/user?userid=" + userid);
//			}
//		} catch (Exception e) {
//			logger.debug("registUser doPost() try 예외발생 >> registUser doPost() 재실행");
//			doGet(req, resp);
//		}

		// ### SERVICE 객체를 사용하여 예외 처리
		int insertUser = userService.insertUserx(userVo);
		logger.debug("insertUser : {}", insertUser);
		if (insertUser == 1) {
			// 정상수행
			logger.debug("registUser doPost() insertUserx()값:1 정상수행 >> /user?userid={} 이동", userid);
			resp.sendRedirect(req.getContextPath() + "/user?userid=" + userid);
		} else {
			// 예외발생시 수행
			logger.debug("registUser doPost() insertUserx()값:0 예외발생 >> registUser doPost() 재실행");
			doGet(req, resp);
		}
	}

}
