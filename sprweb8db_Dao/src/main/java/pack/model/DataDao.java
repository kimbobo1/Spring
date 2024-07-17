package pack.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pack.model.DataDao.ItemRowMapper;

@Repository
public class DataDao extends JdbcDaoSupport{
	
	@Autowired
	public DataDao(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	public List<JikwonDto> getDataAll(String jik){
		String sql = "select jikwon_no,jikwon_name,jikwon_gen,jikwon_pay from jikwon where jikwon_jik=?";
		Object[] param = {jik};
		
		return (List)getJdbcTemplate().query(sql, param,new ItemRowMapper());
	}
	
	class ItemRowMapper implements RowMapper<Object>{
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			JikwonDto dto = new JikwonDto();
			dto.setJikwon_no(rs.getString("jikwon_no"));
			dto.setJikwon_name(rs.getString("jikwon_name"));
			dto.setJikwon_gen(rs.getString("jikwon_gen"));
			dto.setJikwon_pay(rs.getString("jikwon_pay"));
			return dto;
		}
	}
}
