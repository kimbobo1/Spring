package pack.model;


import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository  // @Component
public class DataSource extends DriverManagerDataSource {
	
	public DataSource() {
		setDriverClassName("org.mariadb.jdbc.Driver");
		setUrl("jdbc:mariadb://localhost:3306/test2");
		setUsername("root");
		setPassword("bohyun");
	}
}
