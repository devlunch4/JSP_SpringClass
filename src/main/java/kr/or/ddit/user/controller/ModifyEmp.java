package kr.or.ddit.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.EmpVo;
import kr.or.ddit.user.service.EmpService;
import kr.or.ddit.user.service.EmpServiceI;

@WebServlet("/empModify")
public class ModifyEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ModifyEmp.class);
	private EmpServiceI empService = new EmpService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		1) userid parameter 확인
//		2) userService 객체를 이용하여 파라미터에 해당하는 사용자 정보 조회
//		3) request 객체에 2)번 조회된 값을 user란 속성으로 저장
//		4) webapp/user/user.jsp 화면 생성 위임

		logger.debug("ModifyEmp 진입완료");
		int empno = Integer.parseInt(req.getParameter("empno"));
		logger.debug("empno : {}", empno);
		EmpVo emp = empService.selectOneEmp(empno);
		req.setAttribute("emp", emp);
		logger.debug("EmpVo emp 값 : {}, emp.getEname() : {}", emp, emp.getEname());
		req.getRequestDispatcher("/user/empModify.jsp").forward(req, resp);
	}
}
