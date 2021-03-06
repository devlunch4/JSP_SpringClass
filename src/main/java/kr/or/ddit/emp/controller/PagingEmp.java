package kr.or.ddit.emp.controller;

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
import kr.or.ddit.emp.model.EmpVo;
import kr.or.ddit.emp.service.EmpService;
import kr.or.ddit.emp.service.EmpServiceI;

@WebServlet("/pagingEmp")
public class PagingEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(PagingEmp.class);
	private EmpServiceI empService = new EmpService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("doGet() 진입완료");
		String pageParam = req.getParameter("page");
		String pageSizeParam = req.getParameter("pagesize");
		logger.debug("초기 입력 파라미터 pageParam : {}, req.pageSize : {}", pageParam, pageSizeParam);

		int page = pageParam == null ? 1 : Integer.parseInt(pageParam);
		int pagesize = pageSizeParam == null ? 4 : Integer.parseInt(pageSizeParam);

		logger.debug("세팅 된 page : {}, pageSize : {}", page, pagesize);
		PageVo pagevo = new PageVo(page, pagesize);

		Map<String, Object> map = empService.selectPagingEmp(pagevo);

		List<EmpVo> empList = (List<EmpVo>) map.get("empList");
		int empCnt = (int) map.get("empCnt");
		int pagination = (int) Math.ceil((double) empCnt / pagesize);
		logger.debug("empCnt 값 : {}, pagination 값 : {}", empCnt, pagination);
		req.setAttribute("empList", empList);
		req.setAttribute("pagination", pagination);
		req.setAttribute("pagevo", pagevo);
		logger.debug("In /PagingEmp doGet() >> Forward : PagingEmp.jsp //");
		req.getRequestDispatcher("/emp/pagingEmp.jsp").forward(req, resp);
	}

}
