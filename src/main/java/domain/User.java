package domain;

public class User {

	private String username;
	private String password;
	private String isPremium;
	private String isAdministrator;
	
	
	
	
	
	/*public User(String username, String password, boolean isPremium, boolean isAdministrator) {
		super();
		this.username = username;
		this.password = password;
		this.isPremium = isPremium;
		this.isAdministrator = isAdministrator;
	}*/
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String isPremium() {
		return isPremium;
	}
	public void setPremium(String isPremium) {
		this.isPremium = isPremium;
	}
	public String isAdministrator() {
		return isAdministrator;
	}
	public void setAdministrator(String isAdministrator) {
		this.isAdministrator = isAdministrator;
	}
	
	
	
}
