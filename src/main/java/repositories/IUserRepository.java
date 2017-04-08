package repositories;

import java.sql.SQLException;

import domain.User;

public interface IUserRepository {
	
	User getUserByUsername(String username) throws SQLException;
	
	void add(User u) throws SQLException;
	
	void setPremiumPrivilege(String username) throws Exception;
	
	void setAdministratorPrivilege(String username) throws Exception;
	
	int getSize() throws Exception;

}
