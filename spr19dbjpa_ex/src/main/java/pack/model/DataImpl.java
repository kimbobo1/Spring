package pack.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

@Repository
public class DataImpl implements DataInterface{

	@Override
	public List<JikwonDto> selectDataAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager(); //엔티티 생명주기를 관리 CRUD를 수행
		EntityTransaction tx = em.getTransaction(); // Transaction을 관리하는 인터페이스
		
		List<JikwonDto> list = null; 
		try {
			System.out.println("전체 자료 읽기(JPQL 사용)-----");
		
			list=em.createQuery("select e from JikwonDto as e", JikwonDto.class).getResultList();
			
			String jpql= "select e.buser_num, count(e) from JikwonDto e group by buser_num";
			List<Object[]> results = em.createQuery(jpql).getResultList();
			
			for (Object[] result : results) {
				Integer buserNum = (Integer)result[0];
				long count = (long)result[1];
				 System.out.println("부서번호 :"+ buserNum+" " + "직원수 :" +" "+ count);
				 
			} 
		
		} catch (Exception e) {
			tx.rollback();
			System.out.println("err" + e);
			
		}finally {
			
			em.close();
			emf.close();
		}
		//select buser_num,count(*) from jikwon group by buser_num;
		//list=em.createQuery("select e.buser_num,count(e) from JikwonDto as e group by e.buser_num",JikwonDto.class).getResultList();
		return list;
		
	}
	// JPQL 임 SQL문장 아님
	public<T> List<T> findAll(EntityManager em, Class<T> cla){
		//cla.getName() :pack.model.DataDto
		//cla/getSimpleName() : DataDto
		return em.createQuery("select e from " + cla.getSimpleName() + " e", cla).getResultList();
	}
}
