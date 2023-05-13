package DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class BillInfor {
	private String staffName;
	private String cusName;
	private int idBill;
	private String courseName;
	private LocalDate date;
	private int total;
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public int getIiBill() {
		return idBill;
	}
	public void setIiBill(int iiBill) {
		this.idBill = iiBill;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public BillInfor (int idBill,String cusName, String staffName,String courseName, int total) {
	this.idBill = idBill;
	this.cusName = cusName;
	this.staffName = staffName;
	this.courseName = courseName;
	this.date = LocalDateTime.now().toLocalDate();
	this.total = total;
	}
}
