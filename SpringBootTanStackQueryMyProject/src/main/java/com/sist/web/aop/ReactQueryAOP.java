package com.sist.web.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect // 공통 모듈
@Component // 메모리 할당
public class ReactQueryAOP {
	// 로그			모든 리턴형							모든 메소드, 모든 매개변수
	@Around("excution(* com.sist.web.controller.*Controller.*(..))")
	public Object around(ProceedingJoinPoint jp) throws Throwable{
		long start=System.currentTimeMillis();
		Object obj=jp.proceed();// 메소드 호출
		long end=System.currentTimeMillis();
		System.out.println("클라이언트 호출 메소드:"+jp.getSignature().getName());
		System.out.println("걸린 시간:"+(end-start));
		return obj;
	}
}
