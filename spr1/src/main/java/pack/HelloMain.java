package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		// 처리 1: 전통적인 방법
		Message1 m1 = new Message1();
		m1.sayHello("신선해");
		
		Message2 m2 = new Message2();
		m2.sayHello("신기루");
		System.out.println();
		
		MessageInter inter;
		inter = m1;
		inter.sayHello("손오공공칠빵");
		inter = m2;
		inter.sayHello("저팔계");
		System.out.println("------");
		//처리 2 : Spring을 사용 resoures에 만듬
		//ApplicationContext context = new ClassPathXmlApplicationContext("classpath:pack/Init.xml");
		//init.xml이 pack에 있을경우
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Init.xml");
		MessageInter inter2 = (MessageInter)context.getBean("mes1");
		inter2.sayHello("뉴비");
		MessageInter inter3 = (MessageInter)context.getBean("mes2");
		inter3.sayHello("~고인물");
		

	}

}
