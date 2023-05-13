package BLL;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.processing.Messager;
import javax.swing.JOptionPane;

import DAL.DAOCourse;
import DTO.Course;

public class BLLCourse {
	private static BLLCourse instance;
	public static BLLCourse Instance() {
		if(instance == null)
			instance = new BLLCourse();
		return instance;
	}
	public void Delete(int id) {
		try {
			if(DAOCourse.getInstance().selectByID(id) == null)
				JOptionPane.showMessageDialog(null, String.format("Khong ton tai khoa tap co id la: %d", id));
			else {
				int choice = JOptionPane.showConfirmDialog(null, "Ban co that su muon xoa khoa tap nay?",null, JOptionPane.YES_NO_OPTION);
				if(choice == JOptionPane.YES_OPTION) {
					DAOCourse.getInstance().delete(id);
					JOptionPane.showMessageDialog(null, "Da xoa thanh cong");
				}
			}
		} catch (HeadlessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insert(String name,int price) {
		// Vì id tự tăng nên khi thêm khóa tập không được nhập id
		Course course = new Course(name,price);
		int choice = JOptionPane.showConfirmDialog(null, "Ban co that su muon them khoa tap nay?",null, JOptionPane.YES_NO_OPTION);
		if(choice == JOptionPane.YES_OPTION) {
			try {
				if(DAOCourse.getInstance().insert(course) > 0)
					JOptionPane.showMessageDialog(null,"Da them khoa tap thanh cong");
				else
					JOptionPane.showMessageDialog(null,"Them khoa tap that bai");		
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public Course selectById(int id) throws ClassNotFoundException, SQLException {
		return DAOCourse.getInstance().selectByID(id);
	}
	public ArrayList<Course> selectAll() throws ClassNotFoundException, SQLException{
		return DAOCourse.getInstance().selectAll();
	}
}
