package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogicImpl implements LogicInter{
	@Autowired
	private ArticleInter articleInter;
	
	public LogicImpl() {
		
	}
	
	@Override
	public void selectDataProcess1() {
		System.out.println("selectDataProcess1111 수행");
		articleInter.selectAll();  //모델 클래스 수행 결과 출력
	}
	@Override
	public void selectDataProcess2() {
		System.out.println("----------------------");
		System.out.println("selectDataProcess2222 처리");
		articleInter.selectAll();  //모델 클래스 수행 결과 출력
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			
		}
		System.out.println("3초 지연 처리");
	}
}
