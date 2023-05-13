package DTO;

import java.util.Date;

public class BillInfor {
	private String staffName;
	private String cusName;
	private int iiBill;
	private String courseName;
	private Date date;
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
		return iiBill;
	}
	public void setIiBill(int iiBill) {
		this.iiBill = iiBill;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public BillInfor (int idBill,String cusName, String staffName,String courseName,Date date, int total) {
	
	}
}
