package repositories;

import java.util.ArrayList;
import java.util.List;

import domain.User;

public class DummyUserRepository implements IUserRepository {

	private static List<User> db = new ArrayList<User>();
	
	@Override
	public void add(User user) {
		db.add(user);
		System.out.println("User added to the db (dummy list)...");
		for(User u: db){
			System.out.println(u.getUsername() + " | " + u.getPassword() + " | p-" + u.isPremium() + " | a-" + u.isAdministrator());
		}
		
	}

	@Override
	public void setPremiumPrivilege(String username) {
		for(User u: db){
			if(u.getUsername().equalsIgnoreCase(username)){
				u.setPremium("1");
				System.out.println("User has been granted the Premium privilege ...");
			}
			
		}
		
	}

	@Override
	public void setAdministratorPrivilege(String username) {
		for(User u: db){
			if(u.getUsername().equalsIgnoreCase(username)){
				u.setAdministrator("1");
				System.out.println("User has been granted the Administrator privilege ...");
			}
				
		}
		
	}
	
	@Override
	public User getUserByUsername(String username) {
		for(User u: db){
			if(u.getUsername().equalsIgnoreCase(username)) return u;
		}
		return null;
	}

	@Override
	public int getSize() {
		return db.size();
	}

	public static List<User> getDb() {
		return db;
	}

	public static void setDb(List<User> db) {
		DummyUserRepository.db = db;
	}
	
	

}
