package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.DataDao;
import model.DataDaoimpl;

public class ServiceMain {

	public static void main(String[] args) {
		//전통적인 방법
		//DB 처리 객체 생성
		DataDaoimpl impl = new DataDaoimpl();
		DataDao dataDao = impl;
		
		//BL관련 객체를 생성
		ProcessServiceImpl serviceImpl = new ProcessServiceImpl(dataDao);
		ProcessService processService = serviceImpl; //인터페이스
		processService.selectProcess();
		
		System.out.println("----------");
		
		//스프링 방법 사용
		ApplicationContext context = new ClassPathXmlApplicationContext("Init.xml");
		
		ProcessService processService2 = (ProcessService)context.getBean("serviceimpl");
		processService2.selectProcess();

	}

}
