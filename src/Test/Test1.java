package Test;

import java.sql.SQLException;

import DAL.DAOCourse;

public class Test1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(DAOCourse.getInstance().selectAll().size());
	}
}
