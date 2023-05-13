package BLL;

public class BLLBill {
	private static BLLBill instance;
	public static BLLBill Instance() {
		if(instance == null)
			instance = new BLLBill();
		return instance;
	}
	private BLLBill() {
		
	}
	
}
