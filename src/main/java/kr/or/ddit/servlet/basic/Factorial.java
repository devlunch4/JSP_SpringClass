package kr.or.ddit.servlet.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Factorial {

	private static final Logger logger = LoggerFactory.getLogger(Factorial.class);

	public static void main(String[] args) {
		Factorial factorial = new Factorial();

		// 5인 경우
		int result = factorial.calculate(5);

		if (result == 120) {
			logger.debug("success : {}", result);
		} else {
			logger.debug("fail : {}", result);
		}

		// 0인 경우
		result = factorial.calculate(0);

		if (result == 120) {
			logger.debug("success : {}", result);
		} else {
			logger.debug("fail : {}", result);
		}

		// 음수인 경우
		result = factorial.calculate(-3);

		if (result == 120) {
			logger.debug("success : {}", result);
		} else {
			logger.debug("fail : {}", result);
		}
	}

	// alt +shift + j
	/**
	 * Method : calculate 작성자 : PC-20 변경이력 :
	 * 
	 * @param n
	 * @return Method 설명 : 인자로 들어온 n 값을 이용하여 팩토리얼을 계산
	 */
//	private int calculate(int n) {
//		int fac = 1;
//		for (int i = 1; i <= n; i++) {
//			fac = fac * i;
//		}
//		return fac;
//	}

	/**
	 * Method : calculate
	 * 작성자 : PC-20
	 * 변경이력 :
	 * @param n
	 * @return
	 * Method 설명 : 재귀함수 로 설정된 메소드 0!인경우 1, 1!인경우 1
	 * 				나머지는 해당 팩토리얼로
	 */
	public int calculate(int n) {
		if (n <= 1)
			return 1;
		else
			return n * calculate(n - 1);
		// return n * calculate(--n);
	}
}
