package BLL;

import java.awt.HeadlessException;
import java.sql.SQLException;

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
	public void insert(Course course) {
		// Vì id tự tăng nên khi thêm khóa tập không được nhập id
		
	}
}
