package BLL;

public class BLLCustomer {
	private static BLLCustomer instance;
	public static BLLCustomer Instance() {
		if(instance == null)
			instance = new BLLCustomer();
		return instance;
	}
	
}
