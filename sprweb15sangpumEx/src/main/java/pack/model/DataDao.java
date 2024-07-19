package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	@Autowired
	private JikwonRepository repository;
	
	// 전체자료 읽기
	public List<Jikwon> getDataAll(){
		List<Jikwon> list = repository.findAll(); // 기본 메소드
		return list;
	}
	
	// 검색 자료
		public List<Jikwon> getDataSearch(String jik){
		List<Jikwon> list = repository.findByjikwon_jikContaining(jik);
		
		//List<Jikwon> list = repository.searchLike(svalue);
		System.out.println("list : " + list.size());
		return list;
	}
}
