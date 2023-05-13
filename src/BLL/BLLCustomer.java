package BLL;

import java.sql.SQLException;
import java.util.ArrayList;

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
	public ArrayList<Customer> GetAll(){
		try {
			return DAOCustomer.getInstance().selectAll();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
