package pack.gogek;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import pack.bank.Bank;
import pack.bank.HanaBank;
import pack.bank.SinhanBank;

@Service
@ComponentScan("pack.bank")
@Scope("prototype")
public class Gogek {
	private Bank bank;
	
	@Autowired(required = true) //type으로 연결
	//required = false 신한 뱅크가 있으면 매핑하고 없으면 안할거야
	private SinhanBank sinhanBank;
	
	@Resource(name="hanaBank") // name 으로 연결
	private HanaBank hanaBank;
	
	public void selectBank(String sel) {
		if(sel.equals("sinhan")) {
			bank = sinhanBank;
		}else if(sel.equals("hana")){
			bank = hanaBank;
		}
	}
	public void playInputMoney(int money) {//고객이 돈을 입금
		bank.inputMoney(money);
	}
	public void playOutputMoney(int money) {//고객이 돈을 입금
		bank.outputMoney(money);
	}
	
	
	private String msg;
	
	@PostConstruct // 생성자 처리 후 자동 호출 : 초기화 작업 가능
	public void abc() {
		msg="계좌 잔고";
	}
	
	@PreDestroy //웹 서비스 종료 직전 자동 호출 : 마무리 작업 가능
	public void def() {
		if(sinhanBank != null) sinhanBank=null;
		if(hanaBank != null) hanaBank=null;
	}
	
	public void showMoney() {
		//System.out.println("계좌 잔고 :" + bank.getMoney());
		System.out.println(msg + bank.getMoney());
	}
	
}
