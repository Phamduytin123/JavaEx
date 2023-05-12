package DTO;

public class Course {
	private int ID;
	private String Kind;
	private int Price;
	
	
	
	public Course() {
		ID = 0;
		Kind = "";
		Price = 0;
	}
	public Course(int iD, String kind, int price) {
		super();
		ID = iD;
		this.Kind = kind;
		Price = price;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getKind() {
		return Kind;
	}
	public void setKind(String kind) {
		this.Kind = kind;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
}
