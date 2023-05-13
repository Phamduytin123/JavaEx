package DAL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
		String query ="Insert into Course(Kind, Price) Values(?, ?)";
		Connection con = JDBCUtils.getConnection();
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1,t.getKind());
		stmt.setInt(2, t.getPrice());
		data = stmt.executeUpdate();
		stmt.close();
		JDBCUtils.closeConnection(con);
		return data;
	}

	@Override
	public int delete(Integer t) throws SQLException, ClassNotFoundException {
		int data = 0;
		
		Connection con = JDBCUtils.getConnection();
		String sql = "Delete From Course where Id = "+t;
		
		PreparedStatement stmt = con.prepareStatement(sql);
		data = stmt.executeUpdate();
		stmt.close();
		JDBCUtils.closeConnection(con);
		return data;
	}

	@Override
	public int update(Course t) throws SQLException, ClassNotFoundException {
		int data = 0;
		String sql = "Update Course Set Kind = ? , Price = ? where Id = ?";
		Connection con = JDBCUtils.getConnection();
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, t.getKind());
		stmt.setInt(2, t.getPrice());
		stmt.setInt(3, t.getID());
		data = stmt.executeUpdate();
		
		stmt.close();
		JDBCUtils.closeConnection(con);
		return data;
	}

	@Override
	public ArrayList<Course> selectAll() throws SQLException, ClassNotFoundException {
		ArrayList<Course> courses = new ArrayList<Course>();
		
		Connection con = JDBCUtils.getConnection();
		String sql = "Select * from Course";
		PreparedStatement stmt = con.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		try {
			while(rs.next()) {
				int id = rs.getInt(1);
				String kind = rs.getString(2);
				int price = rs.getInt(3);
				Course course = new Course(id,kind,price);
				courses.add(course);
			}
			rs.close();
			stmt.close();
			JDBCUtils.closeConnection(con);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	@Override
	public Course selectByID(Integer t) throws SQLException, ClassNotFoundException {
		Connection con = JDBCUtils.getConnection();
		Course course = null;
		
		String sql = "Select * from Course Where Id = "+t;
		
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		try {
			while(rs.next()) {
				int id = rs.getInt(1);
				String kind = rs.getString(2);
				int price = rs.getInt(3);
				course = new Course(id,kind,price);
			}
			rs.close();
			stmt.close();
			JDBCUtils.closeConnection(con);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return course;
	}
	public ArrayList<Course> selectByKind(String kind) throws SQLException, ClassNotFoundException {
		Connection con = JDBCUtils.getConnection();
		ArrayList<Course> courses  = new ArrayList<Course>();
		
		String sql =String.format("Select * from Course Where Kind = N'%s'",kind);
		
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		try {
			while(rs.next()) {
				int id = rs.getInt(1);
				int price = rs.getInt(3);
				Course course = new Course(id,kind,price);
				courses.add(course);
			}
			rs.close();
			stmt.close();
			JDBCUtils.closeConnection(con);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}
	
}
