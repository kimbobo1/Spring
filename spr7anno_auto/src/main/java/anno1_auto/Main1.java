package anno1_auto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@Configuration //환경을 여기서 설정할거야~~ xml이 필요없다
//@ComponentScan(basePackages = "anno1_auto") //여러개를 계속 스캔할수있다
public class Main1 {

	public static void main(String[] args) {
		//Autowired에 대한 main
		//AnnotationConfigApplicationContext context = 
			//	new AnnotationConfigApplicationContext(Main1.class);
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:anno1.xml");
		//<context:component-scan base-package="anno1_auto" /> <<<xml에서 이걸쓸경우 위방법을 쓴다
		
		SenderProcess process = context.getBean("senderProcess",SenderProcess.class);
		process.dispData();
		
	}

}
