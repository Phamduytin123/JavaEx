package BLL;


import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.DAOEquipment;
import DTO.Equipment;


public class BLLEquipment {
	private static BLLEquipment instance;
	public static BLLEquipment Instance() {
		if(instance == null)
			instance = new BLLEquipment();
		return instance;
	}
	public  void insert(String name, int price, int quantity) {
		Equipment eq = new Equipment(name,price,quantity);
		int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm dụng cụ tập",null,JOptionPane.YES_NO_OPTION);
		if(choice == JOptionPane.YES_OPTION) {
			try {
				if(DAOEquipment.getInstance().insert(eq) > 0)
					JOptionPane.showMessageDialog(null, "Thêm dụng cụ thành công");
				else
					JOptionPane.showMessageDialog(null, "Thêm dụng cụ thất bại");
			} catch (HeadlessException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void update(int iD, String name, int price, int quantity) {
		Equipment eq = new Equipment(iD,name,price,quantity);
		int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn cập nhật dụng cụ tập",null,JOptionPane.YES_NO_OPTION);
		if(choice == JOptionPane.YES_OPTION) {
			try {
				if(DAOEquipment.getInstance().update(eq) > 0)
					JOptionPane.showMessageDialog(null, "Cập nhật dụng cụ thành công");
				else
					JOptionPane.showMessageDialog(null, "Cập nhật dụng cụ thất bại");
			} catch (HeadlessException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void delete(int id) {
		int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa dụng cụ tập",null,JOptionPane.YES_NO_OPTION);
		if(choice == JOptionPane.YES_OPTION) {
			try {
				if(DAOEquipment.getInstance().delete(id) > 0)
					JOptionPane.showMessageDialog(null, "Cập nhật dụng cụ thành công");
				else
					JOptionPane.showMessageDialog(null, "Cập nhật dụng cụ thất bại");
			} catch (HeadlessException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public ArrayList<Equipment> GetAll() throws ClassNotFoundException, SQLException{
		return DAOEquipment.getInstance().selectAll();
	}
	public Equipment selectById(int id) throws ClassNotFoundException, SQLException {
		return DAOEquipment.getInstance().selectByID(id);
	}
}
