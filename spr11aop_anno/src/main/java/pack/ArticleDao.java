package pack;

import org.springframework.stereotype.Repository;

@Repository //DB와 연결해서 작업해줌
public class ArticleDao implements ArticleInter{
	
	@Override
	public void selectAll() {
		System.out.println("테이블 자료 읽기");
		
	}
}
