package DTO;

public class Customer {
	private int ID;
	private String Name;
	private String PhoneNumber;
	private String Gender;
	
	public Customer() {
		ID = 0;
		Name = "";
		PhoneNumber = "";
		Gender 	= "Nam";
	}
	public Customer(int iD, String name, String phoneNumber, String gender) {
		super();
		ID = iD;
		Name = name;
		PhoneNumber = phoneNumber;
		Gender = gender;
	}
	public Customer( String name, String phoneNumber, String gender) {
		super();
		Name = name;
		PhoneNumber = phoneNumber;
		Gender = gender;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	
}
