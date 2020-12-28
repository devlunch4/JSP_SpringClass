package kr.or.ddit.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TimeTableServlet
 */
public class TimeTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();

		String code = "";
		code += "<html>";
		code += "<head>";
		code += "<title>TimeTableServlet</title>";
		code += "<style>";
		code += "table, tr, td{border: 1px solid black;}";
		code += "table{width : 100%; text-align : center;}";
		code += "</style>";
		code += "</head>";
		code += "<body'>";
		code += "<h1>구구단 출력하기</h1>";
		code += "<h1>URL 설정 >> http://localhost/TimsTableServlet</h1>";
		code += "<table>";
		for (int i = 1; i < 10; i++) {
			code += "<tr>";
			for (int j = 2; j < 10; j++) {
				code += "<td>";
				code += j + " * " + i + " = " + (j * i);
				code += "</td>";
			}
			code += "</tr>";
		}
		code += "</table> ";
		code += "</body>";

		code += "</html>";

		pw.println(code);

		pw.flush();
		pw.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
