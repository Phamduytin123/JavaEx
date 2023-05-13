package DTO;

public class Equipment {
	private int ID;
	private String Name;
	private int Price;
	private int Quantity;
	public int getID() {
		return ID;
	}
	public Equipment() {
		ID = 0;
		Name = "";
		Price = 0;
		Quantity = 0;
	}
	public Equipment(int iD, String name, int price, int quantity) {
		super();
		ID = iD;
		Name = name;
		Price = price;
		Quantity = quantity;
	}
	public Equipment(String name, int price, int quantity) {
		super();
		Name = name;
		Price = price;
		Quantity = quantity;
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
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
}
