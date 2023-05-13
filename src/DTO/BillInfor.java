package DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class BillInfor {
	private String staffName;
	private String cusName;
	private int idBill;
	private String phonenum;
	private String kind;
	private LocalDate date;
	private int total;
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getIdBill() {
		return idBill;
	}
	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
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
	public BillInfor (int idBill,String cusName, String staffName,String phonenumber,String kind, int total) {
	this.idBill = idBill;
	this.cusName = cusName;
	this.staffName = staffName;
	this.phonenum = phonenumber;
	this.kind = kind;
	this.date = LocalDateTime.now().toLocalDate();
	this.total = total;
	}
	public BillInfor (int idBill,String cusName, String staffName,String phonenumber,String kind, LocalDate date,int total) {
		this.idBill = idBill;
		this.cusName = cusName;
		this.staffName = staffName;
		this.phonenum = phonenumber;
		this.kind = kind;
		this.date = date;
		this.total = total;
		}
}
