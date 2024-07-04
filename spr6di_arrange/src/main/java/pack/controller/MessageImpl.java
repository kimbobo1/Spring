package pack.controller;

import pack.model.MyInfoInter;
import pack.other.OutFileInter;

public class MessageImpl implements MessageInter{
	
	//MyInfoInter 타입의 파생 클래스중!! 하나로  MessageImpl 작성
	private String message1,message2;//constructo(생성자) injection용
	private int year;
	private MyInfoInter infoInter;
	//setter
	private String spec; //setter injection 용
	private OutFileInter fileInter;
	
	
	
	public MessageImpl(String message1,String message2,int year,MyInfoInter infoInter) {//생성자 주입
		this.message1 = message1;
		this.message2 = message2;
		this.year = year;
		this.infoInter = infoInter;
		
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	
	public void setFileInter(OutFileInter fileInter) {
		this.fileInter = fileInter;
	}
	@Override
	public void sayHi() {
		String msg = " MessageImpl 클래스에서 sayHi 내용 :";
		msg += " \n" + message1 + " " + message2;
		msg += " \n" + (year+2000) + "년";
		msg += " \n" + infoInter.myData();
		msg += " \n" + spec;
		
		System.out.println(msg); //콘솔로 출력함
		
		//위 메세지를 파일로 출력하기!!
		fileInter.outFile(msg);
		
	}
}
