package com.sist.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
// 서버 구동 => Spring - App
// 환경 설정 => XML => properties , yml
// 버전관리 / 라이브러리 관리 / 프로젝트 관리 => maven / gradle
// 형상 관리 : GTI , SVN
/*
 * 	Spring - Boot
 * 		=> Spring - Framework 를 기반 웹개발을 단순화하고 빠른 개발 / 배포 지원
 * 															-------- 배포 jar
 * 		=> XML 설정 없이 간단하게 구성 = 자동 구성, 내장 웹 서버를 가지고 있다
 * 			=> server.port = 80
 * 				=> default : 8080
 * 				=> AWS에서는 0~1023 => 알려진 포트(사용 불가)
 * 				  ---- 보안 그룹 : 허용 => 8080/1521
 * 				  => 단점 : 우분투 설정
 * 						   ---- 암호화 / 비대칭 (RSA)
 * 									   ----------- private / public
 * 												   ----------------
 * 				  => webpack => thymeleaf
 * 				  => CI/CD => git Action / docker / 쿠바네티스 / 젠킨스
 * 		=> Spring - Framework / Java, Kotlin
 * 			C / C++ / Java / Kotlin / Dart ... / GO
 * 					  --------------
 * 						Java + JavaScript
 * 		=> 웹 : JSP , Front (Vue3,Vuex,react,react-query)
 * 		=> react / vue 포함 => 3000
 * 		=> 2800 ~ 3200
 * 		   ----   ----
 */
@SpringBootApplication
//@EnableAspectJAutoProxy => 라이브러리 등록시 생략 가능
//@ComponentScan(basePackage="") => 같은 com.sist.web 폴더 안에 있는경우 자동 인식 => 생략
public class SpringBootReactQuery2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReactQuery2Application.class, args);
	}

}
