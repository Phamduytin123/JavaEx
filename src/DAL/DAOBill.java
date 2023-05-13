package DAL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		Date DayBook = t.getDayBook();
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
		Date DayBook = t.getDayBook();
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
		Connector.getInstance().ConnectToDatabase();
		List<Bill> list = new ArrayList<>();
		
		//Bước 3 : Thực hiện câu lệnh truy vấn
		try {
			String sqlCommand = "SELECT * FROM Bill";
			Connector.getInstance().result = Connector.getInstance().excuteQuery(sqlCommand);
		while(Connector.getInstance().result.next())
		{
			 Bill bill = new Bill(Connector.getInstance().result.getInt(1),Connector.getInstance().result.getInt(2),
					 Connector.getInstance().result.getInt(3),Connector.getInstance().result.getInt(4),
					 Connector.getInstance().result.getDate(5),Connector.getInstance().result.getInt(6));
			
			list.add(bill);
		}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return (ArrayList<Bill>) list;
	}
	@Override
	public Bill selectByID(Integer t) throws SQLException, ClassNotFoundException {
		Connection Conn = JDBCUtil.getConnection();
		Statement stmt = Conn.createStatement();
		String sqlCommand = "SELECT * FROM Bill where id = "+t;
		ResultSet rs = stmt.executeQuery(sqlCommand);
		Bill bill = null;
		while(rs.next())
		{
			int ID = rs.getInt(1);
			int IDCustomer = rs.getInt(2);
			int IDCourse = rs.getInt(3);
			int	IDUser = rs.getInt(4);
			Date DayBook = rs.getDate(5);
			int Total = rs.getInt(6); 
			bill = new Bill(ID,IDCustomer,IDCourse,IDUser,DayBook,Total);
		}
		return bill;
	}
}
