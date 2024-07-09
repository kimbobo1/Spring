package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface SqlMapperInter {
	@select("select jikwon_name, jikwon_no,buser_name,year(jikwon_ibsail) from jikwon")
	public List<Dto>
	
	@Select(" select buser_name,count(*) from jikwon right outer join buser on buser_num=buser_no group by buser_name")
	public List<Dto> selectDataAll();
	
}
