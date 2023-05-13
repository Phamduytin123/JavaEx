package Test;

import java.sql.SQLException;

import DAL.DAOBill;
import DAL.DAOBillInfor;
import DAL.DAOCourse;
import DAL.DAOCustomer;
import DAL.DAOEquipment;
import DAL.DAOUser;

public class t {

	public static void main(String[] args) {
			try {
				System.out.println(DAOBillInfor.Instance().getBillInfor(0));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
