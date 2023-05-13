package BLL;

import java.sql.SQLException;
import java.util.ArrayList;

import DAL.DAOEquipment;
import DTO.Equipment;

public class BLLEquipment {
	private static BLLEquipment instance;
	public static BLLEquipment Instance() {
		if(instance == null)
			instance = new BLLEquipment();
		return instance;
	}
	public ArrayList<Equipment> GetAll(){
		try {
			return DAOEquipment.getInstance().selectAll();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
