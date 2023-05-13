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
	public void insert(String name, String PhoneNumber, String Gender) {
		Customer cus = new Customer(name,PhoneNumber,Gender);
		int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm khách hàng này?",null,JOptionPane.YES_NO_OPTION);
		if(choice == JOptionPane.YES_OPTION) {
			try {
				if(DAOCustomer.getInstance().insert(cus) > 0)
					JOptionPane.showMessageDialog(null, "Thêm khách hàng thất bại");
				else
					JOptionPane.showMessageDialog(null, "Thêm khách hàng thất bại");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void delete(int id) {
		int choice = JOptionPane.showConfirmDialog(null, "Bạn thật sự muốn xóa khách hàng này?",null,JOptionPane.YES_NO_OPTION);
		if(choice == JOptionPane.YES_OPTION) {
			try {
				if(DAOCustomer.getInstance().delete(id) > 0)
					JOptionPane.showMessageDialog(null, "Xóa khách hàng thành công");
				else
					JOptionPane.showMessageDialog(null, "Xóa khách hàng thất bại");
			} catch (HeadlessException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void update(int id, String name, String phonenum, String gender) {
		Customer cus = new Customer(id,name,phonenum,gender);
		int choice = JOptionPane.showConfirmDialog(null, "Bạn có thật sự muốn cập nhật khách hàng này?",null,JOptionPane.YES_NO_OPTION);
		if(choice == JOptionPane.YES_OPTION) {
			try {
				if(DAOCustomer.getInstance().update(cus) > 0)
					JOptionPane.showMessageDialog(null, "Cập nhật khách hàng thành công");
				else
					JOptionPane.showMessageDialog(null, "Cập nhật khách hàng thất bại");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public Customer selectById(int id) throws ClassNotFoundException, SQLException {
		return DAOCustomer.getInstance().selectByID(id);
	}
	public ArrayList<Customer> selectAll() throws ClassNotFoundException, SQLException{
		return DAOCustomer.getInstance().selectAll();
	}
}
