package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	public BillInfor getBillInfor(int id) throws SQLException {
		BillInfor billinfor = null;
		
		Connection con = JDBCUtils.getConnection();
		String query = String.format("Select b.ID,b.Total,b.DateBook,ua.FullName ,c.NameCus,co.Kind From Bill as b, UserAccount as ua, Customer as c,Course as co \r\n"
				+ "	Where  b.ID  = %d and b.IDCustomer = c.ID and b.IDUser = ua.ID and b.IDCourse = co.ID",id);
		
		PreparedStatement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
//		try {
//			PreparedStatement stmt = Connector.getInstance().conn.prepareStatement(query);
//			rs = stmt.executeQuery(query);
//			while(rs.next()) {
//				
//				
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		return billinfor;
	}
}
