package kr.or.ddit.emp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.emp.service.EmpService;
import kr.or.ddit.emp.service.EmpServiceI;

@WebServlet("/empDelete")
public class EmpDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(EmpDelete.class);
	private EmpServiceI empService = new EmpService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("EmpDelete doPost() 진입");
		int empno = Integer.parseInt(req.getParameter("empno"));
		int deleteCnt = 0;
		try {
			deleteCnt = empService.deleteEmp(empno);
		} catch (Exception e) {
			deleteCnt = -1;
		}
		if (deleteCnt == 1) {
			logger.debug("empno값: {} 삭제 완료", empno);
			resp.sendRedirect(req.getContextPath() + "/pagingEmp");
		} else {
			resp.sendRedirect(req.getContextPath() + "/emp?empno=" + empno);
		}
	}
}
