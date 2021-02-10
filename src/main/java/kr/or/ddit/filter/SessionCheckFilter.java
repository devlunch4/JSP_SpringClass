package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;

public class SessionCheckFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(SessionCheckFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 요청 URI가 S_USER 속성이 세션에 있어야하는 주소인지 체크
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		logger.debug("request uri : {}", uri);
		// !!!!!! 세션체크가 필요없는 주소 : login.jsp / loginController
		if (uri.endsWith("login.jsp") || uri.endsWith("loginController") || uri.contains("/css/")
				|| uri.contains("/js/") || uri.contains("/image/")) {
			logger.debug("세션체크가 필요없는 주소 진입 [login.jsp / loginController]");
			chain.doFilter(request, response);
		}
		// !!!!!! 세션체크가 필요 없는 주소(S_USER 속성 확인)
		else {
			UserVo user = (UserVo) req.getSession().getAttribute("S_USER");
			// user 정보가 NULL ==> 로그인을 안함 ==> 로그인 화면으로 이동
			if (user == null) {
				// 포워드하면 문제가 발생할수 있음. 리다이렉트를 사용
				logger.debug("user 정보가 NULL");
				((HttpServletResponse) response).sendRedirect(req.getContextPath() + "/login.jsp");
			}
			// user 정보가 !NULL ==> 로그인한 상태 ==>
			else {
				logger.debug("user 정보가 !NULL user값 : {}", user);
				chain.doFilter(request, response);
			}
		}

		// session에 S_USER 속성이 있는 지 확인.
		// 바로 requset.getSession 하려면 타입변경이 필요
		// 다음 줄에 작성한 코드는 처음 작성한 코드 이지만 방향성의 문제로 사용하지 않는다.
		// HttpSession session = ((HttpServletRequest) request).getSession();

	}

	@Override
	public void destroy() {

	}

}
