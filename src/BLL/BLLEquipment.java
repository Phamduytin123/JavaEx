package BLL;

import DTO.Equipment;

public class BLLEquipment {
	private static BLLEquipment instance;
	public static BLLEquipment Instance() {
		if(instance == null)
			instance = new BLLEquipment();
		return instance;
	}
	public void insert(String name,int price,int quantity) {
		Equipment equipment = new Equipment(name,price,quantity);
		//JOptionPane.showMessageDialog(null, String.format("Khong ton tai khoa tap co id la: %d", id));JOptionPane.showMessageDialog(null,"Khong ton tai khoa tap co id la: %d");
	}
}
