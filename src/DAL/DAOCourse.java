package DAL;

import java.sql.Connection;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer t) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Course t) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Course> selectAll() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		Connection Conn = JDBCUtil.getConnection(); 
		List<Course> list = new ArrayList<>();
		
		//Bước 3 : Thực hiện câu lệnh truy vấn 
		Statement stmt = Conn.createStatement();
		String sqlCommand = "SELECT * FROM Course";
		ResultSet rs = stmt.executeQuery(sqlCommand); 
		while(rs.next())
		{
			int ID = rs.getInt(1);
			String Kind = rs.getString(2);
			int Price = rs.getInt(3);
			
			list.add(new Course(ID, Kind, Price));
		}
		
		rs.close();
		stmt.close();
				
		JDBCUtil.closeConnection(Conn);
		return (ArrayList<Course>) list;

	}

	@Override
	public Course selectByID(Integer t) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
