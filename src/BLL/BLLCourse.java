package BLL;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.processing.Messager;
import javax.swing.JOptionPane;

import DAL.DAOCourse;
import DAL.DAOCustomer;
import DAL.DAOEquipment;
import DTO.Course;
import DTO.Customer;
import DTO.Equipment;

public class BLLCourse {
	private static BLLCourse instance;
	public static BLLCourse Instance() {
		if(instance == null)
			instance = new BLLCourse();
		return instance;
	}
	public boolean Delete(int id) {
		try {
			return DAOCourse.getInstance().delete(id) > 0;
			
		} catch (HeadlessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
	public boolean insert(String name,int price) {
		// Vì id tự tăng nên khi thêm khóa tập không được nhập id
		Course eq = new Course(name,price);
		try {
			return DAOCourse.getInstance().insert(eq) > 0;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
	public boolean update(int id, String kind, int price) {
		Course eq = new Course(id,kind,price);
		try {
			return DAOCourse.getInstance().update(eq) > 0;
		} catch (HeadlessException | ClassNotFoundException | SQLException e) {
			return false;
		}
	}
	public Course selectById(int id) throws ClassNotFoundException, SQLException {
		return DAOCourse.getInstance().selectByID(id);
	}
	public ArrayList<Course> selectAll() throws ClassNotFoundException, SQLException{
		return DAOCourse.getInstance().selectAll();
	}
	public ArrayList<Course> selectAll(String kind) throws ClassNotFoundException, SQLException{
		return DAOCourse.getInstance().selectByKind(kind);
	}
}
