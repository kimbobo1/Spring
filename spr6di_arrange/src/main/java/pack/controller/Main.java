package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
//		ApplicationContext context = //xml연결~
//					new ClassPathXmlApplicationContext("classpath:arrange.xml");
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:arrange.xml");
		
		System.out.println("---싱글톤 확인하세요~");
		MessageImpl impl1 = (MessageImpl)context.getBean("mImpl");
		impl1.sayHi();
		MessageImpl impl2 = (MessageImpl)context.getBean("mImpl");
		impl2.sayHi();
		System.out.println("객체 주소:" + impl1 + " " + impl2 );//싱글톤 패턴 객체의 주소가 똑같다
		
		System.out.println("\n---다형성 처리 하세요~");
		MessageInter inter = (MessageInter)context.getBean("mImpl");
		inter.sayHi();
		
		
		System.out.println("\n---다형성 처리 하세요222~");
		MessageInter inter2 = context.getBean("mImpl",MessageInter.class);
		inter.sayHi();
		context.close();
	}

}
