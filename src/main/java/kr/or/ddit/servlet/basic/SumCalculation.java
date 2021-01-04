package kr.or.ddit.servlet.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/sumCalculation")

public class SumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(SumCalculation.class);

	public SumCalculation() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));
		int sum = 0;

		for (int i = start; i <= end; i++) {
			sum += i;
		}

		request.setAttribute("start", start);
		request.setAttribute("end", end);

		logger.debug("start : {} end : {}", start, end);
		logger.debug("두 숫자의 합 : {}", sum);

		HttpSession session = request.getSession();
		session.setAttribute("sumResult", sum);

		request.getRequestDispatcher("/jsp/sumResult.jsp").forward(request, response);

	}

}
