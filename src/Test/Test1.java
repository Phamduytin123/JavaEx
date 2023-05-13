package Test;

import java.sql.SQLException;

import BLL.BLLCustomer;
import DAL.DAOCourse;
import DAL.DAOCustomer;
import DAL.DAOEquipment;

public class Test1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(DAOCourse.getInstance().selectAll().size());
	}
}
