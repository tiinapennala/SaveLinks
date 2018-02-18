package model;

public class User {
	private int user_id;
	private String firstname, lastname, email, username, password;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int user_id, String firstname, String lastname, String email, String username, String password) {
		super();
		this.user_id = user_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	public int getUser_id() {
		return user_id;
	}
	
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
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
	
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", username=" + username + ", password=" + password + "]";
	}
	
}
