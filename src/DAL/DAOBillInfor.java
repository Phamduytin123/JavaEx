package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DTO.BillInfor;

public class DAOBillInfor  {
	private static DAOBillInfor instance;
	public static DAOBillInfor Instance() {
		if(instance == null)
			instance = new DAOBillInfor();
		return instance;
	}
	private DAOBillInfor() {
		
	}
	public BillInfor getBillInfor(int id) {
		BillInfor billinfor = null;
		Connector.getInstance().ConnectToDatabase();
		String query = String.format("Select b.ID,b.Total,b.DateBook,ua.FullName ,c.NameCus,co.Kind From Bill as b, UserAccount as ua, Customer as c,Course as co \r\n"
				+ "	Where  b.ID  = %d and b.IDCustomer = c.ID and b.IDUser = ua.ID and b.IDCourse = co.ID",id);
		ResultSet rs = null;
		try {
			PreparedStatement stmt = Connector.getInstance().conn.prepareStatement(query);
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return billinfor;
	}
}
