package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemRepository extends JpaRepository<Mem, Integer>{
	// num 자동 증가용
	@Query(value = "select max(m.num) from Mem as m")
	//@Query(value = "select max(num) from Mem",nativeQuery = true)
	int findByMaxNum();
	
	
}
