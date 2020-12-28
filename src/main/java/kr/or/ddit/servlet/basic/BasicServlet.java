package kr.or.ddit.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(BasicServlet.class);

	@Override
	public void init() throws ServletException {
		System.out.println("test >>> BasicServlet.init()");
	}

	// doXXX 메소드인자 : req, res
	// GET POST DELETE PUSH HEAD... : HTTP METHOD
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		logger.debug("test >>> BasicServlet.doGet()");

		// 만약에 log level을 debug 보다 높을 레벨로 설정할 경우
		// 로그를 생성하지는 않지만 메소드 인자인 문자열 + 문자열 ==> 문자열 결합 연산은 발생한다.
		// 로그에서 문자열 결합 연산을 하지 않도록 하는것이 좋다.
		// 예시 if(설정로그레벨 <= debug) { logger.debug("해당 문구")}
		// >>> 해결을 위해서 해당 debug 메소드 확인해보면 가변인자를 사용한다.
		// public void debug(String format, Object... arguments);
		// 중괄호를 사용한다
		logger.debug("BasicServlet.doGet() userid parameter : {} {}", req.getParameter("userid"),
				req.getParameter("password"));

		// 기존
		logger.debug("BasicServlet.doGet() userid parameter : " + req.getParameter("userid"));

		resp.setContentType("text/html;charset=UTF-8");

		// 재정의
		// 요청을 생성할 떄마다 서버의 현재시간이 달라진다
		// new Date 부분을 db 에서 조회한 데이터라고 생각해보면
		// 사용자 별로 요청에 대한 응답을 각각 다르게 생성하는 것이 가능하다.
		// db에 대한 연동 부분은 html, javascript만 이용해서는 불가능 ==> 정적
		// servlet을 통해 응답으로 생성하는 html을 동적으로 변경 ==> 동적(servlet/jsp를 배우는 이유)

		// servlet의 라이프 사이틀
		// init() ==> service() ==> destroy()
		// 로딩 최초1회 사용자가 요청을 할떄마다 서버종료 or reload

		// init 메소드는 해당 서블릿에서 사용한 자원을 초기화 할때 사용
		// 로딩시 최초1회 호출 : 로딩 되는 시점 ==> 해당 서블릿으로 최초 요청일 들어왔을때
		// 단 web.xml의 servlet 엘레멘트의 하위 엘레멘트인 load-on-startup 엘레먼트 값으로
		// 양의 정수 값을 입력할 경우 서버가 기동하면서 바로 init 메소드를 호출한다.

		// servlet container가 요청을 처리하는 방법
		// 등록된 url 매핑을 참고하여 등록된 서블릿으로 요청을 전달(서블릿 메소드 호출)
		// localhost/basicCervlet ==> BasicServlet의 서비스 메소드를 통해 응답 생성
		// localhost/index.jsp ==> servlet 설정에 있는 web xml에 등록된
		// *.jsp, *jspx url-pattern에 따라 jsp라는 이름의 서블리에서 처리 (JspServlet)
		// localhost/doc/20201223.txt 정적자료
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("	<head>");
		pw.println("		<title>hello servlet world</title>");
		pw.println("	</head>");
		pw.println("	<body>");
		pw.println("Hello, servlet World" + new Date());
		pw.println("	</body>");
		pw.println("<html>");

		pw.flush(); // 더이상 작성할 내용이 없으므로 작업을 마무리 한다
		pw.close(); // 사용한 자원은 반납
	}

}
