package anno1_auto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //<<이걸쓰면 싱글톤으로 객체가 만들어짐 
//싱글톤 패턴으로 Sender 객체가 생성. 객체 변수명은 sender (소문자)
//@Component("sender")//<<같은이야기임
//@Scope("singleton")
public class Sender implements SenderInter{
	public void show() {
		 System.out.println("Sender의 show 메소드 수행");
	}
}
