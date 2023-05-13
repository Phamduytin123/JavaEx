package BLL;


import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.DAOEquipment;
import DTO.Equipment;


public class BLLEquipment {
	private static BLLEquipment instance;
	public static BLLEquipment Instance() {
		if(instance == null)
			instance = new BLLEquipment();
		return instance;
	}
	public  boolean insert(String name, int price, int quantity) {
		Equipment eq = new Equipment(name,price,quantity);
			try {
				return DAOEquipment.getInstance().insert(eq) > 0;
			} catch (HeadlessException | ClassNotFoundException | SQLException e) {
				return false;
			}
	}
	public boolean update(int iD, String name, int price, int quantity) {
		Equipment eq = new Equipment(iD,name,price,quantity);
			try {
				return DAOEquipment.getInstance().update(eq) > 0;
			} catch (HeadlessException | ClassNotFoundException | SQLException e) {
				return false;
			}
	}
	public boolean delete(int id) {
			try {
				return DAOEquipment.getInstance().delete(id) > 0;
				
			} catch (HeadlessException | ClassNotFoundException | SQLException e) {
				return false;
			}
	}
	public ArrayList<Equipment> GetAll() throws ClassNotFoundException, SQLException{
		return DAOEquipment.getInstance().selectAll();
	}
	public Equipment selectById(int id) throws ClassNotFoundException, SQLException {
		return DAOEquipment.getInstance().selectByID(id);
	}
}
