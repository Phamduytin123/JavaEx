package DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.User;

public class DAOUser implements DAOUtils<User, Integer> {

	@Override
	public int insert(User t) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer t) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(User t) throws SQLException, ClassNotFoundException {
		int data = 0;
		int id = t.getID();
		String username = t.getUserName();
		String password = t.getPassword();
		String role = t.getRole();
		String fullname = t.getFullName();
		String address = t.getAddress();
		Connector.getInstance().ConnectToDatabase();
		String query = String.format("Update UserAccount Set UserName = %s, UserPassword = %s, ", null);
		return data;
	}

	@Override
	public ArrayList<User> selectAll() throws SQLException, ClassNotFoundException {
		ArrayList<User> users = new ArrayList<User>();
		Connector.getInstance().ConnectToDatabase();
		String query = "Select * from UserAccount";
		ResultSet rs = null;
		try {
			rs = Connector.getInstance().excuteQuery(query);
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
			Connector.getInstance().conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User selectByID(Integer t) throws SQLException, ClassNotFoundException {
		User user = null;
		Connector.getInstance().ConnectToDatabase();
		String query = "Select * from UserAccount Where Id = "+t;
		ResultSet rs = null;
		try {
			rs = Connector.getInstance().excuteQuery(query);
			while(rs.next()) {
				int id = rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				String role = rs.getString(4);
				String fullname = rs.getString(5);
				String address = rs.getString(6);
				
				user = new User(id,username,password,role,fullname,address);
			}
			Connector.getInstance().conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
