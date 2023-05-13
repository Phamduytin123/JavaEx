package DTO;

import java.sql.Date;
import java.time.LocalDate;

public class Bill {
	private int ID;
	private int IDCustomer;
	private int IDCourse;
	private int IDUser;
	private LocalDate DayBook;
	private int Total;
	
	public Bill() {
		ID = 0;
		IDCustomer = 0;
		IDCourse = 0;
		IDUser = 0;
		DayBook = LocalDate.now();
		Total = 0;
	}
	
	public int getIDCustomer() {
		return IDCustomer;
	}

	public void setIDCustomer(int iDCustomer) {
		IDCustomer = iDCustomer;
	}

	public Bill(int iD, int iDCustomer, int iDCourse, int iDUser, int total) {
		super();
		ID = iD;
		IDCustomer = iDCustomer;
		IDCourse = iDCourse;
		IDUser = iDUser;
		DayBook = LocalDate.now();
		Total = total;
	}
	public Bill(int iD, int iDCustomer, int iDCourse, int iDUser,LocalDate dayBook, int total) {
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
	public LocalDate getDayBook() {
		return DayBook;
	}
	public void setDayBook(LocalDate dayBook) {
		DayBook = dayBook;
	}
	public int getTotal() {
		return Total;
	}
	public void setTotal(int total) {
		this.Total = total;
	}
}
