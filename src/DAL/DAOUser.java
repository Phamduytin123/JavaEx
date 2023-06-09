package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.User;

public class DAOUser implements DAOUtils<User, Integer> {
	private static DAOUser instance = new DAOUser();
	public static DAOUser getInstance()
	{
		return instance;
	}
	@Override
	public int insert(User t) throws SQLException, ClassNotFoundException {
		int data = 0;

		String query = "Insert into UserAccount( UserName, UserPassword, UserRole, FullName, UserAddress) Values( ?, ?, ?, ?, ?)";

		Connection con = JDBCUtils.getConnection();
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1,t.getUserName());
		stmt.setString(2,t.getPassword());
		stmt.setString(3,t.getRole());
		stmt.setString(4,t.getFullName());
		stmt.setString(5,t.getAddress());
		data = stmt.executeUpdate();
		stmt.close();
		JDBCUtils.closeConnection(con);
		return data;
	}

	@Override
	public int delete(Integer t) throws SQLException, ClassNotFoundException {
		int data = 0;

		String query = "Delete from UserAccount Where Id = "+t;

		Connection con = JDBCUtils.getConnection();
		PreparedStatement stmt = con.prepareStatement(query);
		data = stmt.executeUpdate();
		stmt.close();
		JDBCUtils.closeConnection(con);
		return data;
	}

	@Override
	public int update(User t) throws SQLException, ClassNotFoundException {
		int data = 0;
		String query = "Update UserAccount Set UserName = ?, UserPassword = ?, UserRole = ?, FullName = ?, UserAddress = ? Where Id = ?" ;
		Connection con = JDBCUtils.getConnection();
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, t.getUserName());
		stmt.setString(2, t.getPassword());
		stmt.setString(3, t.getRole());
		stmt.setString(4, t.getFullName());
		stmt.setString(5, t.getAddress());
		stmt.setInt(6, t.getID());
		data =stmt.executeUpdate();
		stmt.close();
		JDBCUtils.closeConnection(con);
		return data;
	}

	@Override
	public ArrayList<User> selectAll() throws SQLException, ClassNotFoundException {
		ArrayList<User> users = new ArrayList<User>();
		Connection con = JDBCUtils.getConnection();
		String query = "Select * from UserAccount";
		PreparedStatement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		try {
			while(rs.next()) {
				int id = rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				String role = rs.getString(4);
				String fullname = rs.getString(5);
				String address = rs.getString(6);
				User user = new User(id,username,password,role,fullname,address);
				users.add(user);
			}
			rs.close();
			stmt.close();
			JDBCUtils.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User selectByID(Integer t) throws SQLException, ClassNotFoundException {
		User user = null;
		Connection con = JDBCUtils.getConnection();
		String query = "Select * from UserAccount Where Id = "+t;
		PreparedStatement stmt = con.prepareStatement(query);
		
		ResultSet rs = stmt.executeQuery();
		try {
			while(rs.next()) {
				int id = rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				String role = rs.getString(4);
				String fullname = rs.getString(5);
				String address = rs.getString(6);
				
				user = new User(id,username,password,role,fullname,address);
			}
			rs.close();
			stmt.close();
			JDBCUtils.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public int selectByUserNameAndPass(String username, String pass) throws SQLException {
		int data = 0;
		ArrayList<User> users = new ArrayList<User>();
		Connection con = JDBCUtils.getConnection();
		String query = String.format("Select * from UserAccount Where UserName = N'%s' AND UserPassword = N'%s'",username,pass);
		PreparedStatement stmt = con.prepareStatement(query);
		
		ResultSet rs = stmt.executeQuery();
		try {
			while(rs.next()) {
				int id = rs.getInt(1);
				String user = rs.getString(2);
				String password = rs.getString(3);
				String role = rs.getString(4);
				String fullname = rs.getString(5);
				String address = rs.getString(6);
				User u = new User(id,user,password,role,fullname,address);
				users.add(u);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
			rs.close();
			stmt.close();
			JDBCUtils.closeConnection(con);
		data = users.size();
		return data;
}
	public ArrayList<User> selectByUserName(String username) throws SQLException {
		int data = 0;
		ArrayList<User> users = new ArrayList<User>();
		Connection con = JDBCUtils.getConnection();
		String query = String.format("Select * from UserAccount Where UserName = N'%s'",username);
		PreparedStatement stmt = con.prepareStatement(query);
		
		ResultSet rs = stmt.executeQuery();
		try {
			while(rs.next()) {
				int id = rs.getInt(1);
				String user = rs.getString(2);
				String password = rs.getString(3);
				String role = rs.getString(4);
				String fullname = rs.getString(5);
				String address = rs.getString(6);
				User u = new User(id,user,password,role,fullname,address);
				users.add(u);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
			rs.close();
			stmt.close();
			JDBCUtils.closeConnection(con);
		data = users.size();
		return users;
}
}
