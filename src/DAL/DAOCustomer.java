package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Customer;

public class DAOCustomer implements DAOUtils<Customer, Integer>{

	@Override
	public int insert(Customer t) throws SQLException, ClassNotFoundException {
		int data = 0;
		String name= t.getName();
		String phonenum = t.getPhoneNumber();
		String gender = t.getGender();
		Connector.getInstance().ConnectToDatabase();
		String query = String.format("Insert into Customer(NameCus , PhoneNumber , Gender) Values ( %s, %s, %s)",name,phonenum,gender);
		try {
			data = Connector.getInstance().ExcecuteNonQuery(query);
			Connector.getInstance().conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public int delete(Integer t) throws SQLException, ClassNotFoundException {
		int data = 0;
		Connector.getInstance().ConnectToDatabase();
		String query = "Delete Customer where Id = "+t;
		try {
			data = Connector.getInstance().ExcecuteNonQuery(query);
			Connector.getInstance().conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return data;
	}

	@Override
	public int update(Customer t) throws SQLException, ClassNotFoundException {
		int data = 0;
		int id = t.getID();
		String name = t.getName();
		String phonenum = t.getPhoneNumber();
		String gender = t.getGender();
		String sql = String.format("Update Customer Set NameCus = %s , PhoneNumber = %s , Gender = %s where Id = %d",name,phonenum,gender,id);
		Connector.getInstance().ConnectToDatabase();
		try {
			data = Connector.getInstance().ExcecuteNonQuery(sql);
			Connector.getInstance().conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public ArrayList<Customer> selectAll() throws SQLException, ClassNotFoundException {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		ResultSet rs = null;
		String query = "Select * from Customer";
		Connector.getInstance().ConnectToDatabase();
		try {
			PreparedStatement stmt = Connector.getInstance().conn.prepareStatement(query);
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String phonenum = rs.getString(3);
				String gender = rs.getString(4);
				Customer customer = new Customer(id,name,phonenum,gender);
				customers.add(customer);
			}
			Connector.getInstance().conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public Customer selectByID(Integer t) throws SQLException, ClassNotFoundException {
		Customer customer = null;
		String query = "Select * from Customer where Id = "+t;
		ResultSet rs = null;
		Connector.getInstance().ConnectToDatabase();
		try {
			PreparedStatement stmt = Connector.getInstance().conn.prepareStatement(query);
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				int id = rs.getInt(1);
				String Name = rs.getString(2);
				String phoneNumber = rs.getString(3);
				String Gender = rs.getString(4);
				customer = new Customer(id,Name,phoneNumber,Gender);
			}
			Connector.getInstance().conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

}
