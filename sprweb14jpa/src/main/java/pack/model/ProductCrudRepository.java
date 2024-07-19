package pack.model;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProductCrudRepository extends JpaRepository<ProductVo, Integer>{
	// CrudRepository > PagingAndSortingRepository > JpaRepository 
	// JpaRepository 얘한테 기능이 다 들어있다
	
	//JPQL
	/*엔티티 객체를 조회하는 객체지향 쿼리로 테이블을 대상으로 쿼리하는 것이 아니라 엔티티 객체를 대상으로 쿼리한다. 
	문법은 SQL과 유사하며 간결하다. JPQL은 최종적으로 SQL로 변환된다.

	JPQL은 SQL을 추상화해서 특정 데이터베이스에 의존하지 않는다는 특징이 있다.
	데이터베이스 hibernate.dialect(방언)만 변경하면 JPQL을 수정하지 않아도 데이터베이스를 변경할 수 있다.*/
	
	// 메소드 이름으로 쿼리 생성 방법 find + (엔티티 이름) + By + 변수이름
	// 엔티티의 이름은 생략이 가능
	@Query(value="select p from ProductVo as p")
	List<ProductVo> findAllData();
	
	ProductVo findByCode(Integer code);
	
	// where 조건
	@Query(value="select p from ProductVo as p where p.code=:code")
	ProductVo findByCodeMy(@Param("code") int code);
	
	@Query(value="select p from ProductVo as p where p.code=?1")
	ProductVo findByCodeMy2(int code);
	
	@Query(value="select p from ProductVo as p where p.code=?1 or p.sang=?2")
	List<ProductVo> findByData(int code, String sang);
	
	// native Query문 사용
	@Query(value = "select code,sang,su,dan from product where code <= 5", nativeQuery = true)
	List<ProductVo> findAllData2();
	
}
