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

	@Override
	public int insert(Bill t) throws SQLException, ClassNotFoundException {
		int data = 0;
		int IdCustomer = t.getIDCustomer();
		int IdCourse = t.getIDCourse();
		int IdUser = t.getIDUser();
		LocalDate DayBook = t.getDayBook();
		int Total = t.getTotal();
		Connector.getInstance().ConnectToDatabase();
		try {			
			String sql = String.format("Insert into Bill(IdCustomer,IdCourse,IdUser,DateBook,Total) Values(%d,%d,%d,%s,%d)",IdCustomer,IdCourse,IdUser,DayBook,Total);
			data = Connector.getInstance().ExcecuteNonQuery(sql);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public int delete(Integer t) throws SQLException, ClassNotFoundException {
		int data = 0;
		Connector.getInstance().ConnectToDatabase();
		try {
			String sql = "Delete Bill Where Id = "+t;
			data = Connector.getInstance().ExcecuteNonQuery(sql);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public int update(Bill t) throws SQLException, ClassNotFoundException {
		int data = 0;
		int Id = t.getID();
		int IdCustomer = t.getIDCustomer();
		int IdCourse = t.getIDCourse();
		int IdUser = t.getIDUser();
		LocalDate DayBook = t.getDayBook();
		int Total = t.getTotal();
		Connector.getInstance().ConnectToDatabase();
		try {			
			String sql = String.format("Update Bill Set IdCustomer = %d, IdCourse = %d, IdUser = %d, Total = %d, DateBook = %s where id = %d ",IdCustomer,IdCourse,IdUser,Total,DayBook,Id);
			data = Connector.getInstance().ExcecuteNonQuery(sql);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public ArrayList<Bill> selectAll() throws SQLException, ClassNotFoundException {
		ArrayList<Bill> bills = new ArrayList<Bill>();
		String query = "Select * from Bill";
		Connector.getInstance().ConnectToDatabase();
		ResultSet rs = null;
		try {
			rs = Connector.getInstance().excuteQuery(query);
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
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bills;
	}
	@Override
	public Bill selectByID(Integer t) throws SQLException, ClassNotFoundException {
		String query = "Select * from Bill where Id = "+t;
		Bill bill = null;
		Connector.getInstance().ConnectToDatabase();
		ResultSet rs = null;
		try {
			rs = Connector.getInstance().excuteQuery(query);
			while(rs.next()) {
				int ID = rs.getInt(1);
				int IDCustomer = rs.getInt(2);
				int IDCourse = rs.getInt(3);
				int	IDUser = rs.getInt(4);
				LocalDate DayBook = rs.getDate(5).toLocalDate();
				int Total = rs.getInt(6); 
				bill = new Bill(ID,IDCustomer,IDCourse,IDUser,DayBook,Total);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bill;
	}
}
