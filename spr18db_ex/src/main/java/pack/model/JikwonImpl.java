package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import pack.mybatis.SqlMapConfig;

@Repository
public class JikwonImpl implements JikwonInter{
   private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
   
   @Override
   public List<Dto> selectDataAll() {
      SqlSession sqlSession = factory.openSession();
      List<Dto> list = null;
      
      try {
    	  SqlMapperInter mapperInter = 
    			  (SqlMapperInter)sqlSession.getMapper(SqlMapperInter.class);
    	  
         list = mapperInter.selectDataAll();
      } catch (Exception e) {
         System.out.println("selectDataAll err: " + e);
      } finally {
         if(sqlSession != null) sqlSession.close();
      }
      return list;
   }
}
