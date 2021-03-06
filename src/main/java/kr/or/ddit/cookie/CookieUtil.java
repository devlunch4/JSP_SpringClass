package kr.or.ddit.cookie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CookieUtil.java
 *
 * @author PC-20
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정자 수정내용
 * ------ ------------------------
 * PC-20 최초 생성
 *
 *      </pre>
 */
public class CookieUtil {

	/**
	 * Method : getCookieValue 작성자 : PC-20 변경이력 :
	 * 
	 * @param cookiestr
	 * @param cookieName
	 * @return Method 설명 : cookieStr에서 cookieName에 해당하는 쿠키 값을 조회
	 * 
	 */

	// cookieStr : "userid=brown; rememberme=Y; test=testcookie"
	// cookieName : userid rememberme
	// return : brown, Y

	private static final Logger logger = LoggerFactory.getLogger(CookieUtil.class);

	public static String getCookieValue(String cookieStr, String cookieName) {

		// split으로 구분자로 만들어 배열화 한다. 스플릿은 배열로 반환한다,
		String cookies[] = cookieStr.split("; ");
		// cookies[0] = userid=brown
		// cookies[1] = rememberme=Y
		// cookies[2] = test=testcookie

		for (String cookieString : cookies) {
			logger.debug(cookieString);
			// cookieString : 쿠키이름:쿠키값
			String[] cookie = cookieString.split("=");
			// cookie[0] : 쿠키이름
			// cookie[1] ::쿠키값
			if (cookie[0].equals(cookieName)) {
				logger.debug("cookie[0] : {} // cookie[1] : {}", cookie[0], cookie[1]);
				return cookie[1];
			}
		}
		return "";
	}
}
