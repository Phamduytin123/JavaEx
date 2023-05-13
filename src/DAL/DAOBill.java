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
		
		String sql = String.format("Insert into Bill(IdCustomer,IdCourse,IdUser,DateBook,Total) Values(%d,%d,%d,%s,%d)",t.getIDCustomer(),t.getIDCourse(),t.getDayBook(),t.getTotal());
		Connection con = JDBCUtils.getConnection();
		
		PreparedStatement stmt = con.prepareStatement(sql);
		data = stmt.executeUpdate();
		
		stmt.close();
		JDBCUtils.closeConnection(con);
		
		return data;
	}

	@Override
	public int delete(Integer t) throws SQLException, ClassNotFoundException {
		int data = 0;
		String sql = "Delete Bill Where Id = "+t;
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
		String sql = String.format("Update Bill Set IdCustomer = %d, IdCourse = %d, IdUser = %d, Total = %d, DateBook = %s where id = %d ",t.getIDCustomer(),t.getIDCourse(),t.getIDUser(),t.getTotal(),t.getDayBook(),t.getID());
		Connection con = JDBCUtils.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		
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
}
