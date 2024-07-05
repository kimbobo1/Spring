package pack.gogek;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GogekMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bankinit.xml");
		
		Gogek daniel = (Gogek)context.getBean("gogek");
		daniel.selectBank("sinhan");
		daniel.playInputMoney(500);
		daniel.playOutputMoney(200);
		System.out.print("daniel - ");
		daniel.showMoney();
		
		Gogek kim = (Gogek)context.getBean("gogek"); //kim과 daniel은 같은 객체...
		kim.selectBank("sinhan");
		kim.playInputMoney(500);
		kim.playOutputMoney(200);
		System.out.print("kim - ");
		kim.showMoney();
		
		Gogek bo = (Gogek)context.getBean("gogek");
		bo.selectBank("hana");
		bo.playInputMoney(500);
		bo.playOutputMoney(100);
		System.out.print("bo - ");
		bo.showMoney();
		
		//Gogek이란 같은 인스턴스를 써서 주소가 같다 이럴경우 싱글톤 패턴을 쓰면 안댐 
		//@Scope("prototype")이걸 써줘서 바꿔줘야함 기본은 싱글톤타입
		System.out.println("객체 주소daniel! : " + daniel);
		System.out.println("객체 주소kim! : " + kim);
		System.out.println("객체 주소bo! : " + bo);
	}

}
