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

@WebServlet("/empModify")
public class EmpModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(EmpModify.class);
	private EmpServiceI empService = new EmpService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		logger.debug("doGet() 진입완료");
		int empno = Integer.parseInt(req.getParameter("empno"));
		logger.debug("empno : {}", empno);
		EmpVo emp = empService.selectOneEmp(empno);
		req.setAttribute("emp", emp);
		logger.debug("EmpVo emp 값 : {}, emp.getEname() : {}", emp, emp.getEname());
		req.getRequestDispatcher("/emp/empModify.jsp").forward(req, resp);
	}

	// EMP 정보 수정
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("EmpModify doPost 진입완료");

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		int empno = Integer.parseInt(req.getParameter("empno"));
		String ename = req.getParameter("ename");
		String job = req.getParameter("job");
		int mgr = Integer.parseInt(req.getParameter("mgr"));

		String hiredate = req.getParameter("hiredate");
		logger.debug("hiredate값 : {}", hiredate);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		Date hiredate_fm = null;

		try {
			hiredate_fm = dateFormat.parse(hiredate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		int sal = Integer.parseInt(req.getParameter("sal"));
		int comm = Integer.parseInt(req.getParameter("comm"));
		int deptno = Integer.parseInt(req.getParameter("deptno"));

		EmpVo empvo = new EmpVo(empno, ename, job, mgr, hiredate_fm, sal, comm, deptno);
		logger.debug("empvo값 : {}", empvo);
		int updateCnt = empService.updateEmp(empvo);
		if (updateCnt == 1) {
			logger.debug("EMP empvo:{}, ename:{} 수정 완료", empvo, ename);
			resp.sendRedirect(req.getContextPath() + "/emp?empno=" + empno);
		} else {
			doGet(req, resp);
		}
	}
}
