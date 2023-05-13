package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import DTO.Customer;

public class DAOCustomer implements DAOUtils<Customer, Integer>{
	private static DAOCustomer instance = new DAOCustomer();
	public static DAOCustomer getInstance()
	{
		return instance;
	}
	@Override
	public int insert(Customer t) throws SQLException, ClassNotFoundException {
		int data = 0;
		Connection con = JDBCUtils.getConnection();
		String query = "Insert into Customer(NameCus , PhoneNumber , Gender) Values ( ?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, t.getName());
		stmt.setString(2, t.getPhoneNumber());
		stmt.setString(3, t.getGender());
		data = stmt.executeUpdate();
		stmt.close();
		JDBCUtils.closeConnection(con);
		return data;
	}

	@Override
	public int delete(Integer t) throws SQLException, ClassNotFoundException {
		int data = 0;
		Connection con = JDBCUtils.getConnection();
		String command ="Delete From Customer Where Id "+t;
		PreparedStatement psm = con.prepareStatement(command);
		data = psm.executeUpdate();
		psm.close();
		JDBCUtils.closeConnection(con);
		return data;
	}

	@Override
	public int update(Customer t) throws SQLException, ClassNotFoundException {
		int data = 0;
		Connection con = JDBCUtils.getConnection();
		String sql = "Update Customer Set NameCus = ? , PhoneNumber = ?, Gender = ? where Id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setString(1, t.getName());
		stmt.setString(2, t.getPhoneNumber());
		stmt.setString(3, t.getGender());
		stmt.setInt(4, t.getID());
		data = stmt.executeUpdate();
		stmt.close();
		JDBCUtils.closeConnection(con);
		return data;
	}

	@Override
	public ArrayList<Customer> selectAll() throws SQLException, ClassNotFoundException {
		ArrayList<Customer> customers = new ArrayList<Customer>();
Connection Conn = JDBCUtils.getConnection(); 
		
		String query = "SELECT * FROM Customer";
		PreparedStatement stmt = Conn.prepareStatement(query);
		
		ResultSet rs = stmt.executeQuery();
		try {
			while(rs.next()) {
				int id = rs.getInt(1);
				String Name = rs.getString(2);
				String phoneNumber = rs.getString(3);
				String Gender = rs.getString(4);
				Customer customer = new Customer(id,Name,phoneNumber,Gender);
				customers.add(customer);
			}
			rs.close();
			stmt.close();
			JDBCUtils.closeConnection(Conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customers;
	}


	@Override
	public Customer selectByID(Integer t) throws SQLException, ClassNotFoundException {
		Connection Conn = JDBCUtils.getConnection(); 
		
		String query = "SELECT * FROM Customer WHERE Id = ?";
		PreparedStatement stmt = Conn.prepareStatement(query);
		
		stmt.setInt(1, t);

		Customer customer = null;
		
		ResultSet rs = stmt.executeQuery();
		try {
			while(rs.next()) {
				int id = rs.getInt(1);
				String Name = rs.getString(2);
				String phoneNumber = rs.getString(3);
				String Gender = rs.getString(4);
				customer = new Customer(id,Name,phoneNumber,Gender);
			}
			rs.close();
			stmt.close();
			JDBCUtils.closeConnection(Conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}
	public Customer selectByPhoneNumber(String phonenum) throws SQLException, ClassNotFoundException {
		Connection Conn = JDBCUtils.getConnection(); 
		
		String query = "SELECT * FROM Customer WHERE Id = N'?'";
		PreparedStatement stmt = Conn.prepareStatement(query);
		
		stmt.setString(1, phonenum);

		Customer customer = null;
		
		ResultSet rs = stmt.executeQuery();
		try {
			while(rs.next()) {
				int id = rs.getInt(1);
				String Name = rs.getString(2);
				String phoneNumber = rs.getString(3);
				String Gender = rs.getString(4);
				customer = new Customer(id,Name,phoneNumber,Gender);
			}
			rs.close();
			stmt.close();
			JDBCUtils.closeConnection(Conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

}
