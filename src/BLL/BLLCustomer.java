package BLL;

import java.awt.HeadlessException;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.DAOCustomer;
import DAL.DAOEquipment;
import DTO.Customer;
import DTO.Equipment;

public class BLLCustomer {
	private static BLLCustomer instance;
	public static BLLCustomer Instance() {
		if(instance == null)
			instance = new BLLCustomer();
		return instance;
	}
	public boolean insert(String name, String PhoneNumber, String Gender) {
		Customer cus = new Customer(name,PhoneNumber,Gender);
			try {
				return DAOCustomer.getInstance().insert(cus) > 0;
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				return false;
			}
			
		
	}
	public boolean delete(int id) {
			try {
				return DAOCustomer.getInstance().delete(id) > 0;
					
			} catch (HeadlessException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				return false;
			}
	}
	public boolean update(int id, String name, String phonenum, String gender) {
		Customer cus = new Customer(id,name,phonenum,gender);
		
			try {
				return DAOCustomer.getInstance().update(cus) > 0;
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return false;
			}
		
	}
	public Customer selectById(int id) throws ClassNotFoundException, SQLException {
		return DAOCustomer.getInstance().selectByID(id);
	}
	public ArrayList<Customer> selectAll() throws ClassNotFoundException, SQLException{
		return DAOCustomer.getInstance().selectAll();
	}
	public Customer selectByPhone(String phone)  {
		try {
			return DAOCustomer.getInstance().selectByPhoneNumber(phone);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
