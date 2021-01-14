package kr.or.ddit.emp.controller;

import java.io.IOException;
import java.util.List;

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
import kr.or.ddit.login.web.LoginController;

@WebServlet("/allEmp")
public class AllEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	private EmpServiceI empservice = new EmpService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<EmpVo> empList = empservice.selectAllEmp();
		req.setAttribute("empList", empList);
		req.getRequestDispatcher("/emp/allEmp.jsp").forward(req, resp);
		logger.debug("In /allEmp doGet() >> Forward : allEmp.jsp");
	}
}
