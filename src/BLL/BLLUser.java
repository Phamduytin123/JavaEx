package BLL;

import java.awt.HeadlessException;
import java.rmi.server.UID;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.DAOCustomer;
import DAL.DAOEquipment;
import DAL.DAOUser;
import DTO.User;

public class BLLUser {
	private static BLLUser instance;
	public static BLLUser Instance() {
		if(instance == null)
			instance = new BLLUser();
		return instance;
	}
	public boolean insert(String userName, String password, String role, String fullName, String address) {
		User user = new User(userName,password,role,fullName,address);
		try {
			return DAOUser.getInstance().insert(user) > 0;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
	public boolean delete(int id) {
		try {
			return DAOUser.getInstance().delete(id) > 0;
				
		} catch (HeadlessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
	public boolean update(int iD, String userName, String password, String role, String fullName, String address) {
		User user = new User(iD,userName,password,role,fullName,address);
		try {
			return DAOUser.getInstance().update(user) > 0;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return false;
		}
	}
	public User selectById(int id) throws ClassNotFoundException, SQLException {
		return DAOUser.getInstance().selectByID(id);
	}
	public ArrayList<User> selecAll() throws ClassNotFoundException, SQLException{
		return DAOUser.getInstance().selectAll();
	}
}
