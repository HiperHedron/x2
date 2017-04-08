package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import repositories.IUserRepository;

public class HSQLDBConnect implements IUserRepository {

	private Connection connection = null;
	private ResultSet resultSet = null;
	private Statement statement = null;

	    public void connectHSQLDB() {
	        try {
	            Class.forName("org.hsqldb.jdbcDriver");
	            String dburl = "jdbc:hsqldb:hsql://localhost/";
	            String userid = "SA";
	            String password = "";
	            String database = "workdb";
	            connection = DriverManager.getConnection(dburl + database, userid, password);
	            System.out.println(dburl + database);
	            System.out.println("SUCCESS:HSQLDB JDBC driver loaded and connection established.");
	            statement = connection.createStatement();
	        } catch (Exception e) {
	        	System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
	            e.printStackTrace();
	            return;
	        }
	    }
	    
	    public List<User> getRows() throws SQLException{
	    	String sql = "select * from users;";
	    	ArrayList<User> ulist = new ArrayList<User>();
	    	User tempu;// = new User();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				tempu = new User();
				String un = resultSet.getString("username");
				String pw = resultSet.getString("password");
				String ip = resultSet.getString("ispremium");
				String ia = resultSet.getString("isadministrator");
				
				tempu.setUsername(un);
				tempu.setPassword(pw);
				tempu.setPremium(ip);
				tempu.setAdministrator(ia);
				ulist.add(tempu);
				
				System.out.println("u:"
						+ un + " / "
						+ pw + " / "
						+ ip + " / "
						+ ia);
			}
			
			/*for(User u : ulist){
				System.out.println(u.getUsername() + " " + u.getPassword());
			}*/
			return ulist;
	    }
	    
	    
	    public List<String> getRowByUsername(String username) throws SQLException{
	    	String sqlStatement = "";
	    	connection.prepareStatement(sqlStatement);
	    	return null;
	    }
	
	    public void insertTestRows() throws SQLException{
	    	for(int i=1;i<10;i++){
	    	String sql = "INSERT into users values (null,'a"+i+"','a"+i+"','0','0')";
	    	
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery(sql);
	    	}
	    }

		@Override
		public User getUserByUsername(String username) throws SQLException {
			String sql = "select * from users where username = '"+username+"';";
	    	User u = new User();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				System.out.println("u:"
						+ resultSet.getString("username") + " / "
						+ resultSet.getString("password") + " / "
						+ resultSet.getString("ispremium") + " / "
						+ resultSet.getString("isadministrator"));
				u.setUsername(resultSet.getString("username"));
				u.setPassword(resultSet.getString("password"));
				u.setPremium(resultSet.getString("ispremium"));
				u.setAdministrator(resultSet.getString("isadministrator"));
				
			}
			System.out.println("getUser" + u.getUsername() + " " + u.getPassword() + " " + u.isPremium() + " " + u.isAdministrator());
			return u;
		}

		@Override
		public void add(User u) throws SQLException {
			if(connection==null){
				System.out.println("xxxxx");
			}
			String sql = "INSERT into USERS VALUES (null,'"+u.getUsername()+"','"+u.getPassword()+"','0','0')";
			//String sql = "INSERT INTO `users` VALUES (null,'asd','asd','0','0');";
			statement.execute(sql);
		}

		@Override
		public void setPremiumPrivilege(String username) throws Exception {
			String sql = "update users set ispremium = '1' where username = '"+username+"';";
	    	
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery(sql);
			connection.commit();
			statement.close();
			
		}

		@Override
		public void setAdministratorPrivilege(String username) throws Exception {
			String sql = "update users set isadministrator = '1' where username = '"+username+"';";
	    	
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery(sql);
			
		}

		@Override
		public int getSize() throws SQLException {
			int rows =0;
			String sql = "select count(*) from users;";	
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery(sql);
			while (resultSet.next()) {
				rows = resultSet.getInt(1);
			}
			return rows;
		}
		
		public void closeConn(){
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Conn closed...");
			}
		}
}
