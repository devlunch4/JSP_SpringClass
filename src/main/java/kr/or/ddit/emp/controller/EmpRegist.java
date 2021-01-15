package kr.or.ddit.emp.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.emp.model.EmpVo;
import kr.or.ddit.emp.service.EmpService;
import kr.or.ddit.emp.service.EmpServiceI;
import kr.or.ddit.user.model.UserVo;

@WebServlet("/empRegist")
public class EmpRegist extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(EmpRegist.class);
	private EmpServiceI empService = new EmpService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("EmpInsert doGet() 진입");
		req.getRequestDispatcher("/emp/empRegist.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("EmpRegist doPost() 진입");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		// 입력 값 가져오기
		int empno = Integer.parseInt(req.getParameter("empno"));
		String ename = req.getParameter("ename");
		String job = req.getParameter("job");

		// 날짜 설정
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		String hiredate = req.getParameter("hiredate");

		// Date reg_dt_fm = new Date(); 오늘날짜 호출법
		Date hiredate_fm = null;
		try {
			hiredate_fm = dateFormat.parse(req.getParameter("hiredate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		int mgr = Integer.parseInt(req.getParameter("mgr"));

		int sal = Integer.parseInt(req.getParameter("sal"));

		int comm = Integer.parseInt(req.getParameter("comm"));

		int deptno = Integer.parseInt(req.getParameter("deptno"));

		logger.debug("입력값들 중 empno 확인 empno : {}", empno);
		logger.debug("날짜입력값: hiredate: {}, hiredate_fm:{}", hiredate, hiredate_fm);

		EmpVo empVo = new EmpVo(empno, ename, job, mgr, hiredate_fm, sal, comm, deptno);
		logger.debug("empVo 값 : {}", empVo);
		// 서블릿내 예외처리
		try {
			int insertUser = empService.insertEmp(empVo);
			if (insertUser == 1) {
				// 정상수행
				logger.debug("EmpInsert doPost() try 정상수행 >> /emp?empno={} 이동", empno);
				resp.sendRedirect(req.getContextPath() + "/emp?empno=" + empno);
			}
		} catch (Exception e) {
			logger.debug("EmpInsert doPost() try 예외발생 >> EmpInsert doPost() 재실행");
			req.setAttribute("empVo", empVo);
			doGet(req, resp);
		}
	}
}
