package spr12aop_login;

import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
	@Around("execution(public void startProcess())")
	public Object abc(ProceedingJoinPoint joinPoint) throws Throwable{
		
		System.out.println("AOP 시작 : 핵심 로직 수행 전 id 검증");
		
		System.out.println("input id:");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.nextLine();
		scanner.close();
		
		if(!id.equals("ok")) {
			System.out.println("id 불일치! 작업을 종료합니다");
			return null; //null을 리턴하면 밑에 object를 안만남 abc메소드를 빠져나감
		}
		
		Object object = joinPoint.proceed();
		
		return object;
	}
}
