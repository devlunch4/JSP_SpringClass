package kr.or.ddit.servlet.basic;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/scope")
public class Scope extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Scope() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: scope.jsp >>> 콘솔 확인 필요").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

//		request : 속성명 = request, 속성값 =scope파라미터값 + "_request"
		String namescope = request.getParameter("name-scope");
		request.setAttribute("request", namescope + "_request");

//		session : 속성명 = session, 속성값 =scope파라미터값 + "_session"
		// 내장된 세션을 호출 후 request의 세션에서 가져온다
		HttpSession session = request.getSession();
		session.setAttribute("session", namescope + "_session");

//		application : 속성명 = application, 속성값 =scope파라미터값 + "_application"
		ServletContext application = getServletContext();
		application.setAttribute("application", namescope + "_application");

		// GET요청에 대해서는 화면을 webapp/jsp/scope.jsp로 응답 생성 위임
		request.getRequestDispatcher("/jsp/scopeResult.jsp").forward(request, response);

		System.out.println("request" + " : " + request.getAttribute("request"));
		System.out.println("session" + " : " + session.getAttribute("session"));
		System.out.println("application" + " : " + application.getAttribute("application"));
	}
}
