package DTO;

import java.sql.Date;

public class Bill {
	private int ID;
	private int IDCustomer;
	private int IDCourse;
	private int IDUser;
	private Date DayBook;
	private int Total;
	
	public Bill() {
		ID = 0;
		IDCustomer = 0;
		IDCourse = 0;
		IDUser = 0;
		DayBook = Date.valueOf("");
		Total = 0;
	}
	
	public int getIDCustomer() {
		return IDCustomer;
	}

	public void setIDCustomer(int iDCustomer) {
		IDCustomer = iDCustomer;
	}

	public Bill(int iD, int iDCustomer, int iDCourse, int iDUser, Date dayBook, int total) {
		super();
		ID = iD;
		IDCustomer = iDCustomer;
		IDCourse = iDCourse;
		IDUser = iDUser;
		DayBook = dayBook;
		Total = total;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getIDCourse() {
		return IDCourse;
	}
	public void setIDCourse(int iDCourse) {
		IDCourse = iDCourse;
	}
	public int getIDUser() {
		return IDUser;
	}
	public void setIDUser(int iDUser) {
		IDUser = iDUser;
	}
	public Date getDayBook() {
		return DayBook;
	}
	public void setDayBook(Date dayBook) {
		DayBook = dayBook;
	}
	public int getTotal() {
		return Total;
	}
	public void setTotal(int total) {
		this.Total = total;
	}
}
