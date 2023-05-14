package Test;

import java.sql.SQLException;

import BLL.BLLCustomer;
import DAL.DAOCourse;
import DAL.DAOCustomer;
import DAL.DAOEquipment;
import DAL.DAOUser;

public class Test1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(DAOUser.getInstance().selectByUserNameAndPass("tin123", "123"));
	}
}
