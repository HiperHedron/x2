package junittests;

import java.sql.SQLException;

import org.junit.Test;

import domain.HSQLDBConnect;
import domain.User;

public class DbTests {
	public HSQLDBConnect repo = new HSQLDBConnect();

	
	@Test
	public void registerAdminUser() throws SQLException{
		
		User testAdminUser = new User();
		testAdminUser.setUsername("admin");
		testAdminUser.setPassword("123");
		testAdminUser.setPremium("1");
		testAdminUser.setAdministrator("1");
		
		repo.connectHSQLDB();
		repo.add(testAdminUser);
		
		repo.getUserByUsername("admin");
		
		repo.closeConn();
	}

}
