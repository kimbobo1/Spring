package pack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pack.dto.Jikwon;
import pack.entity.JikwonEntity;


public interface JikwonRepository extends JpaRepository<JikwonEntity, String>{
	public List<Jikwon> findAllByOrderByJiknoDesc();
}
