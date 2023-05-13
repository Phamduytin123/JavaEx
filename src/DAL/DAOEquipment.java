package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Equipment;

public class DAOEquipment implements DAOUtils<Equipment, Integer>{

	@Override
	public int insert(Equipment t) throws SQLException, ClassNotFoundException {
		int data = 0;
		String name = t.getName();
		int price = t.getPrice();
		int quantity = t.getQuantity();
		String query = String.format("Insert into Equipment( NameMachine, Price, Quantity) Values ( %s, %d, %d)", name,price,quantity);
		try {
			data = Connector.getInstance().ExcecuteNonQuery(query);
			Connector.getInstance().conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public int delete(Integer t) throws SQLException, ClassNotFoundException {
		int data = 0;
		String query = "Delete Equipment Where Id = "+t;
		Connector.getInstance().ConnectToDatabase();
		try {
			data = Connector.getInstance().ExcecuteNonQuery(query);
			Connector.getInstance().conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public int update(Equipment t) throws SQLException, ClassNotFoundException {
		int data = 0;
		int id = t.getID();
		String name = t.getName();
		int price = t.getPrice();
		int quantity = t.getQuantity();
		Connector.getInstance().ConnectToDatabase();
		String query = String.format("Update Equipment Set NameMachine = %s, Price = %d, Quantity = %d Where Id = %d",name,price,quantity,id);
		try {
			data = Connector.getInstance().ExcecuteNonQuery(query);
			Connector.getInstance().conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public ArrayList<Equipment> selectAll() throws SQLException, ClassNotFoundException {
		ArrayList<Equipment> equipments = new ArrayList<Equipment>();
		Connector.getInstance().ConnectToDatabase();
		String query = "Select * from Equipment";
		ResultSet rs = null;
		try {
			PreparedStatement stmt = Connector.getInstance().conn.prepareStatement(query);
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);
				int quantity = rs.getInt(4);
				Equipment equipment = new Equipment(id,name,price,quantity);
				equipments.add(equipment);
			}
			Connector.getInstance().conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return equipments;
	}

	@Override
	public Equipment selectByID(Integer t) throws SQLException, ClassNotFoundException {
		Equipment equipment = null;
		Connector.getInstance().ConnectToDatabase();
		String query = "Select * from Equipment where id = "+t;
		ResultSet rs = null;
		try {
			PreparedStatement stmt = Connector.getInstance().conn.prepareStatement(query);
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);
				int quantity = rs.getInt(4);
				equipment = new Equipment(id,name,price,quantity);
			}
			Connector.getInstance().conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return equipment;
	}

}
