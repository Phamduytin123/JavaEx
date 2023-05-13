package Test;

import java.sql.SQLException;

import BLL.BLLBill;
import DAL.DAOBill;
import DAL.DAOBillInfor;
import DAL.DAOCourse;
import DAL.DAOCustomer;
import DAL.DAOEquipment;
import DAL.DAOUser;
import GUI.PanelCourse;

public class t {

	public static void main(String[] args) {
			try {
				System.out.println(BLLBill.Instance().getAllBillInfor().size());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
