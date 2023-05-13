package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

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
	public BillInfor getBillInforById(int id) throws SQLException {
		BillInfor billinfor = null;
		
		Connection con = JDBCUtils.getConnection();
		String query = String.format("Select b.ID,b.Total,b.DateBook,ua.FullName ,c.NameCus,c.PhoneNumber,co.Kind From Bill as b, UserAccount as ua, Customer as c,Course as co "
				+ "	Where  b.ID  = %d and b.IDCustomer = c.ID and b.IDUser = ua.ID and b.IDCourse = co.ID",id);
		
		PreparedStatement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		try {
			while(rs.next()) {
				int total = rs.getInt(2);
				LocalDate date = rs.getDate(3).toLocalDate();
				String fullname = rs.getString(4);
				String nameCus = rs.getString(5);
				String phonenum = rs.getString(6);
				String kind = rs.getString(7);
				billinfor = new BillInfor(id,nameCus, fullname,phonenum,kind, date,total);
			}
			rs.close();
			stmt.close();
			JDBCUtils.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return billinfor;
	}
public ArrayList<BillInfor> selectAllBillInfo() throws SQLException {
		
		ArrayList<BillInfor> billinfors = new ArrayList<BillInfor>();
		
		Connection con = JDBCUtils.getConnection();
		String query = String.format("Select b.ID,b.Total,b.DateBook,ua.FullName ,c.NameCus,c.PhoneNumber,co.Kind From Bill as b, UserAccount as ua, Customer as c,Course as co "
				+ "	Where b.IDCustomer = c.ID and b.IDUser = ua.ID and b.IDCourse = co.ID");
		
		PreparedStatement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		try {
			while(rs.next()) {
				int id = rs.getInt(1);
				int total = rs.getInt(2);
				LocalDate date = rs.getDate(3).toLocalDate();
				String fullname = rs.getString(4);
				String nameCus = rs.getString(5);
				String phonenum = rs.getString(6);
				String kind = rs.getString(7);
				BillInfor billinfor = new BillInfor(id,nameCus, fullname,phonenum,kind, date,total);
				billinfors.add(billinfor);
			}
			rs.close();
			stmt.close();
			JDBCUtils.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return billinfors;
	}
//	public ArrayList<BillInfor> selectBillInfoByPhoneNumber(String phonenum) {
//		
//		ArrayList<BillInfor> billinfors = new ArrayList<BillInfor>();
//		
//		
//		return billinfors;
//	}
}
