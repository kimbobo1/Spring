package pack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import other.OtherClass;

@SpringBootApplication
@ComponentScan(basePackages = {"other"})
public class Sprweb13jpaBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sprweb13jpaBasicApplication.class, args)
					.getBean(Sprweb13jpaBasicApplication.class).myExecute();
	}
	@Autowired
	ProductCrudRepository crudRepository;
	@Autowired
	OtherClass class1;
	
	private void myExecute() {
		System.out.println("독립적인 프로그램으로 실행");
		insData();
		delData();
		selectData();
		
		class1.abc();
	} 
	private void insData() {
		//ProductVo productVo = new ProductVo();
		//productVo.setCode(4);
		//....
		//ProductVo productVo = new ProductVo(null, "애플펜슬",2,150000);
		ProductVo productVo = new ProductVo(3, "아이패드",20,550000);
		// 번호를 안주거나 있는 번호이면 insert
		// 반면 있는 번호를 준다?? update로 됨
		
		//System.out.println(productVo.toString());
		crudRepository.save(productVo);
	}
	
	private void delData() {
		crudRepository.deleteById(2); // 있으면 지우고 없으면 통과 에러는 안뜸
	}
	private void selectData() { 
		//전체 자료 읽기 
		List<ProductVo> list = (List<ProductVo>)crudRepository.findAll();
		//System.out.println(list.get(0).getSang());
		//데이타베이스를 바꿔도 소스 코드는 그대로다!!! jpa를 쓰는이유
		for(ProductVo p:list) {
			System.out.println(p.getCode()  + " " + 
								p.getSang() +" "  + 
								p.getSu()   + " " + 
								p.getDan());
		}
		System.out.println();
		// 1개 레코드 읽기
		ProductVo vo = crudRepository.findById(3).get();
		System.out.println(vo.getCode()  + " " + 
							vo.getSang() +" "  + 
							vo.getSu()   + " " + 
							vo.getDan());
	}
}
