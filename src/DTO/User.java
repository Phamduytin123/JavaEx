package DTO;

public class User {
	private int ID;
	private String UserName;
	private String Password;
	private String Role;
	private String FullName;
	private String Address;
	
	public String getFullName() {
		return FullName;
	}
	public String getAddress() {
		return Address;
	}
	public User(int iD, String userName, String password, String role, String fullName, String address) {
		super();
		ID = iD;
		UserName = userName;
		Password = password;
		Role = role;
		FullName = fullName;
		Address = address;
	}
	public User( String userName, String password, String role, String fullName, String address) {
		super();
		UserName = userName;
		Password = password;
		Role = role;
		FullName = fullName;
		Address = address;
	}
	public User() {
		ID = 0;
		UserName = "";
		Password = "";
		Role = "Nhân viên";
		FullName = "";
		Address = "";
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
}
