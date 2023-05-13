package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.rowset.JdbcRowSet;

import DTO.Equipment;

public class DAOEquipment implements DAOUtils<Equipment, Integer>{
	private static DAOEquipment instance = new DAOEquipment();
	public static DAOEquipment getInstance()
	{
		return instance;
	}
	@Override
	public int insert(Equipment t) throws SQLException, ClassNotFoundException {
		int data = 0;
		String query = "Insert into Equipment( NameMachine, Price, Quantity) Values ( ?, ?, ?)";
		Connection con = JDBCUtils.getConnection();
		PreparedStatement stmt = con.prepareStatement(query);
		
		stmt.setString(1, t.getName());
		stmt.setInt(2, t.getPrice());
		stmt.setInt(3, t.getQuantity());
		data = stmt.executeUpdate();
		stmt.close();
		JDBCUtils.closeConnection(con);
		return data;
	}

	@Override
	public int delete(Integer t) throws SQLException, ClassNotFoundException {
		int data = 0;
		String query = "Delete Equipment Where Id = "+t;
		Connection con = JDBCUtils.getConnection();
		PreparedStatement stmt = con.prepareStatement(query);
		data = stmt.executeUpdate();
		stmt.close();
		JDBCUtils.closeConnection(con);
		return data;
	}

	@Override
	public int update(Equipment t) throws SQLException, ClassNotFoundException {
		int data = 0;
		Connection con = JDBCUtils.getConnection();
		String query = "Update Equipment Set NameMachine = ?, Price = ?, Quantity = ? Where Id = ?";
		PreparedStatement stmt = con.prepareStatement(query);
		
		stmt.setString(1,t.getName());
		stmt.setInt(2, t.getPrice());
		stmt.setInt(3, t.getQuantity());
		stmt.setInt(4, t.getID());
		
		data = stmt.executeUpdate();
		stmt.close();
		JDBCUtils.closeConnection(con);
		return data;
	}

	@Override
	public ArrayList<Equipment> selectAll() throws SQLException, ClassNotFoundException {
		ArrayList<Equipment> equipments = new ArrayList<Equipment>();
		Connection con = JDBCUtils.getConnection();
		String query = "Select * from Equipment";
		PreparedStatement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		try {
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);
				int quantity = rs.getInt(4);
				Equipment equipment = new Equipment(id,name,price,quantity);
				equipments.add(equipment);
			}
			rs.close();
			stmt.close();
			JDBCUtils.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return equipments;
	}

	@Override
	public Equipment selectByID(Integer t) throws SQLException, ClassNotFoundException {
		Connection con = JDBCUtils.getConnection();
		String query = "Select * from Equipment where id = "+t;
		Equipment equipment = null;
		
		PreparedStatement stmt = con.prepareStatement(query);
		
		ResultSet rs = stmt.executeQuery();
		try {
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);
				int quantity = rs.getInt(4);
				equipment = new Equipment(id,name,price,quantity);
			}
			rs.close();
			stmt.close();
			JDBCUtils.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return equipment;
	}

}
