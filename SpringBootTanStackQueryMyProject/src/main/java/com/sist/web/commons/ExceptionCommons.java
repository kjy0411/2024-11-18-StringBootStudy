package com.sist.web.commons;

import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
// 공통 예외처리 => @RestController에서만 사용이 가능
// boot => 설정 파일 단순하다 (.yml,.properties) => 라이브러리 설정이 가능
// 웹 관련 호환성이 좋다 => boot > Framework
// MSA => boot : 서버용 , Front => 별도로 작업  boot = react , boot = angular , boot = vue 
// 메모리 할당 
// @Component / Repository / Service / Controller / RestController  
//@RestControllerAdvice
public class ExceptionCommons {
	@ExceptionHandler(Exception.class)
	public void exception(Exception ex) {
		System.out.println("---------- 서버 예외 발생 ----------");
		ex.printStackTrace();
		System.out.println("---------------------------------");
	}
}
