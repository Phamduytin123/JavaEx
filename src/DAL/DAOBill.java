package DAL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import DTO.Bill;
import DTO.BillInfor;
import DTO.Course;

public class DAOBill implements DAOUtils<Bill, Integer>{
	private static DAOBill instance;
	public static DAOBill Instance() {
		if(instance == null)
			instance = new DAOBill();
		return instance;
	}

	@Override
	public int insert(Bill t) throws SQLException, ClassNotFoundException {
		int data = 0;
		
		String sql = "Insert into Bill(IdCustomer,IdCourse,IdUser,DateBook,Total) Values(?,?,?,?,?)";
		Connection con = JDBCUtils.getConnection();
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, t.getIDCustomer());
		stmt.setInt(2, t.getIDCourse());
		stmt.setInt(3, t.getIDUser());
		stmt.setDate(4,Date.valueOf(t.getDayBook()));
		stmt.setInt(5, t.getTotal());
		data = stmt.executeUpdate();
		
		stmt.close();
		JDBCUtils.closeConnection(con);
		
		return data;
	}

	@Override
	public int delete(Integer t) throws SQLException, ClassNotFoundException {
		int data = 0;
		String sql = "Delete From Bill Where Id = "+t;
		Connection con = JDBCUtils.getConnection();
		
		PreparedStatement stmt = con.prepareStatement(sql);
		data = stmt.executeUpdate();
		stmt.close();
		JDBCUtils.closeConnection(con);
		
		return data;
	}

	@Override
	public int update(Bill t) throws SQLException, ClassNotFoundException {
		int data = 0;
		String sql = "Update Bill Set IdCustomer = ?, IdCourse = ?, IdUser = ?, Total = ?, DateBook = ? where id = ? ";
		Connection con = JDBCUtils.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setInt(1,t.getIDCustomer());
		stmt.setInt(2, t.getIDCourse());
		stmt.setInt(3, t.getIDUser());
		stmt.setInt(4, t.getTotal());
		stmt.setDate(5, Date.valueOf(t.getDayBook()));
		stmt.setInt(6, t.getID());
		
		data = stmt.executeUpdate();
		
		stmt.close();
		JDBCUtils.closeConnection(con);
		
		return data;
	}

	@Override
	public ArrayList<Bill> selectAll() throws SQLException, ClassNotFoundException {
		ArrayList<Bill> bills = new ArrayList<Bill>();
		
		Connection con = JDBCUtils.getConnection();
		String query = "Select * from Bill";
		PreparedStatement stmt = con.prepareStatement(query);
		
		ResultSet rs = stmt.executeQuery();
		try {
			while(rs.next()) {
				int ID = rs.getInt(1);
				int IDCustomer = rs.getInt(2);
				int IDCourse = rs.getInt(3);
				int	IDUser = rs.getInt(4);
				LocalDate DayBook = rs.getDate(5).toLocalDate();
				int Total = rs.getInt(6); 
				Bill bill = new Bill(ID,IDCustomer,IDCourse,IDUser,DayBook,Total);
				bills.add(bill);
			}
			rs.close();
			stmt.close();
			JDBCUtils.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bills;
	}
	@Override
	public Bill selectByID(Integer t) throws SQLException, ClassNotFoundException {
		Connection con = JDBCUtils.getConnection();
		String query = "Select * from Bill where Id = "+t;
		PreparedStatement stmt = con.prepareStatement(query);
		
		ResultSet rs = stmt.executeQuery();

		Bill bill = null;
		try {
			while(rs.next()) {
				int ID = rs.getInt(1);
				int IDCustomer = rs.getInt(2);
				int IDCourse = rs.getInt(3);
				int	IDUser = rs.getInt(4);
				LocalDate DayBook = rs.getDate(5).toLocalDate();
				int Total = rs.getInt(6); 
				bill = new Bill(ID,IDCustomer,IDCourse,IDUser,DayBook,Total);
			}
			rs.close();
			stmt.close();
			JDBCUtils.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bill;
	}
	public ArrayList<BillInfor> selectAllBillInfor() throws SQLException{
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
}
