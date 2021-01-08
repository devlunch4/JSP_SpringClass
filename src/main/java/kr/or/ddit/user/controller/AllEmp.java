package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.login.web.LoginController;
import kr.or.ddit.user.model.EmpVo;
import kr.or.ddit.user.service.EmpService;
import kr.or.ddit.user.service.EmpServiceI;

@WebServlet("/allEmp")
public class AllEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	private EmpServiceI empservice = new EmpService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<EmpVo> empList = empservice.selectAllEmp();
		req.setAttribute("empList", empList);
		req.getRequestDispatcher("/user/allEmp.jsp").forward(req, resp);
		logger.debug("In /allEmp doGet() >> Forward : allEmp.jsp");
	}
}
