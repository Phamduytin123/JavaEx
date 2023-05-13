package BLL;

import java.awt.HeadlessException;
import java.rmi.server.UID;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
	public void insert(String userName, String password, String role, String fullName, String address) {
		User user = new User(userName,password,role,fullName,address);
		int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm người dùng?",null,JOptionPane.YES_NO_OPTION);
		if(choice == JOptionPane.YES_OPTION) {
			try {
				if(DAOUser.Instance().insert(user) > 0)
					JOptionPane.showMessageDialog(null, "Thêm người dùng thành công");
				else
					JOptionPane.showMessageDialog(null, "Thêm người dùng thất bại");
			} catch (HeadlessException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void delete(int id) {
		int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa người dùng này",null,JOptionPane.YES_NO_OPTION);
		if(choice == JOptionPane.YES_OPTION) {
			try {
				if(DAOUser.Instance().delete(id) > 0)
					JOptionPane.showMessageDialog(null, "Xóa người dùng thành công");
				else
					JOptionPane.showMessageDialog(null, "Xóa người dùng thất bại");
			} catch (HeadlessException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void update(int iD, String userName, String password, String role, String fullName, String address) {
		User user = new User(iD,userName,password,role,fullName,address);
		int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn cập nhật dụng cụ tập",null,JOptionPane.YES_NO_OPTION);
		if(choice == JOptionPane.YES_OPTION) {
			try {
				if(DAOUser.Instance().update(user) > 0)
					JOptionPane.showMessageDialog(null, "Cập nhật người dùng thành công");
				else
					JOptionPane.showMessageDialog(null, "Cập nhật người dùng thất bại");
			} catch (HeadlessException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public User selectById(int id) throws ClassNotFoundException, SQLException {
		return DAOUser.Instance().selectByID(id);
	}
	public ArrayList<User> selecAll() throws ClassNotFoundException, SQLException{
		return DAOUser.Instance().selectAll();
	}
}
