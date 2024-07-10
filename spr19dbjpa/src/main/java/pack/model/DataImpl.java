package pack.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class DataImpl implements DataInterface{

	@Override
	public List<MemDto> selectDataAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager(); //엔티티 생명주기를 관리 CRUD를 수행
		EntityTransaction tx = em.getTransaction(); // Transaction을 관리하는 인터페이스
		
		List<MemDto> list = null; 
		try {
			//  레코드 추가
//			tx.begin();
//			MemDto dto1 = new MemDto();
//			dto1.setNum(4);
//			dto1.setName("보쿠현");
//			dto1.setAddr("서초구 방배동");
//			em.persist(dto1);
//			// Hibernate: /* insert pack.model.MemDto */ 
//			// 실제 SQl 처리 :insert into mem (addr, name, num) values (?, ?, ?)
//			tx.commit();
			
			// 레코드 수정
//			tx.begin();
//			MemDto dto2 =em.find(MemDto.class, 4); // 대상자 읽고
//			dto2.setName("감자");
//			// Hibernate: select memdto0_.num as num1_0_0_, memdto0_.addr as addr2_0_0_, memdto0_.name as name3_0_0_ from mem memdto0_ where memdto0_.num=?
//			// Hibernate: /* update pack.model.MemDto */ 
//			// 실제 SQl 처리 :update mem set addr=?, name=? where num=?
//			tx.commit();
//			
			// 레코드 삭제
//			tx.begin();
//			MemDto dto3 =em.find(MemDto.class, 4); // 대상자 읽고
//			em.remove(dto3);
//			tx.commit();
			
			System.out.println("부분 자료 읽기(단일 엔티티) find()메소드 사용-----");
			// public find(Class<T> entityClass, Object pk)
			MemDto mdto =em.find(MemDto.class, 1);
			System.out.println(mdto.getNum()+ " " + mdto.getName()+ " " + mdto.getAddr());
			
			System.out.println("부분 자료 읽기(복수 엔티티)");
			List<MemDto> listPart= findByAddr(em, "강남");
			for(MemDto m : listPart) {
				list = findAll(em, MemDto.class);
					System.out.println(m.getNum()+ " " + m.getName()+ " " + m.getAddr());
				}
			
			System.out.println("전체 자료 읽기(JPQL 사용)-----");
//			for(MemDto m : list) {
//			list = findAll(em, MemDto.class);
//				System.out.println(m.getNum()+ " " + m.getName()+ " " + m.getAddr());
//			}
			list=em.createQuery("select e from MemDto as e", MemDto.class).getResultList();
			// Hibernate : => select * from MemDto as e  예는 RDBMS 종류에 관계 없이 공통적으로 사용
			// Hibernate가 DBDialect를 보고 실제 sql문으로 변환 ==>
			// Hibernate: /* select e from MemDto as e */ select memdto0_.num as num1_0_, memdto0_.addr as addr2_0_, memdto0_.name as name3_0_ from mem memdto0_
		} catch (Exception e) {
			tx.rollback();
			System.out.println("err" + e);
			
		}finally {
			
			em.close();
			emf.close();
		}
		
		return list;
	}
	
	public List<MemDto> findByAddr(EntityManager em , String ss){
		// addr 필드가 특정 접두사로 시작하는 레코드 읽기 
		String jpql = "SELECT m FROM MemDto m WHERE  m.addr LIKE :ss";
		
		TypedQuery<MemDto> query = em.createQuery(jpql, MemDto.class);
		// TypedQuery<entity> query = em.createQuery(jpql, entity클래스)
		// JPQL을 작성 하고 실행하는 역할
		query.setParameter("ss", ss+ "%"); // 검색 문자%  SQL의 like연산
		return query.getResultList();
	}
	
	
	// JPQL 임 SQL문장 아님
	public<T> List<T> findAll(EntityManager em, Class<T> cla){
		//cla.getName() :pack.model.DataDto
		//cla/getSimpleName() : DataDto
		return em.createQuery("select e from " + cla.getSimpleName() + " e", cla).getResultList();
	}
}
