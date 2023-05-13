package DAL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.Course;

public class DAOCourse implements DAOUtils<Course, Integer>{
	private static DAOCourse instance = new DAOCourse();
	public static DAOCourse getInstance()
	{
		return instance;
	}

	@Override
	public int insert(Course t) throws SQLException, ClassNotFoundException {
		int data = 0;
		String kind  = t.getKind();
		int price = t.getPrice();
		Connector.getInstance().ConnectToDatabase();
		String query = String.format("Insert into Course(Kind, Price) Values(%s, %d)",kind,price);
		try {
			data = Connector.getInstance().ExcecuteNonQuery(query);
			Connector.getInstance().conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;
	}

	@Override
	public int delete(Integer t) throws SQLException, ClassNotFoundException {
		int data = 0;
		String sql = "Delete Course where Id = "+t;
		Connector.getInstance().ConnectToDatabase();
		try {
			data = Connector.getInstance().ExcecuteNonQuery(sql);
			Connector.getInstance().conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public int update(Course t) throws SQLException, ClassNotFoundException {
		int data = 0;
		int Id = t.getID();
		String Kind = t.getKind();
		int Price = t.getPrice();
		Connector.getInstance().ConnectToDatabase();
		try {			
			String sql = String.format("Update Course Set Kind = %s , Price = %d where Id = %d",Kind,Price,Id);
			data = Connector.getInstance().ExcecuteNonQuery(sql);
			Connector.getInstance().conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public ArrayList<Course> selectAll() throws SQLException, ClassNotFoundException {
		ArrayList<Course> courses = new ArrayList<Course>();
		Connector.getInstance().ConnectToDatabase();
		String sql = "Select * from Course";
		try {
			ResultSet rs = Connector.getInstance().excuteQuery(sql);
			while(rs.next()) {
				int id = rs.getInt(1);
				String kind = rs.getString(2);
				int price = rs.getInt(3);
				Course course = new Course(id,kind,price);
				courses.add(course);
			}
			Connector.getInstance().conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	@Override
	public Course selectByID(Integer t) throws SQLException, ClassNotFoundException {
		Connector.getInstance().ConnectToDatabase();
		Course course = null;
		String sql = "Select * from Course Where Id = "+t;
		try {
			ResultSet rs = Connector.getInstance().excuteQuery(sql);
			while(rs.next()) {
				int id = rs.getInt(1);
				String kind = rs.getString(2);
				int price = rs.getInt(3);
				course = new Course(id,kind,price);
			}
			Connector.getInstance().conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return course;
	}
	
}
