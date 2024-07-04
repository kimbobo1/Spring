package pack.model;

public class MyInfo implements MyInfoInter{
	//MyInfoInter 타입의 파생 클래스중!! 하나로  MyInfo 작성
	
	@Override
	public String myData() {  //myinfointer에서 생성한걸 갖고옴
		
		return "취미는 운동(축구)";
	}
}
