package gas;

public class Street {
	
	/**
	 * 가솔린 리터당 가격
	 */
	public static final double GASOLIN_PRICE = 1569.67;
	/**
	 * 경유 리터당 가격
	 */
	public static final double DIESEL_PRICE = 1651.15;
	/**
	 * LPG 리터당 가격
	 */
	public static final double LPG_PRICE = 1039.35;
	
	public static void main(String[] args) {
		
		GasStation gasStation = new GasStation();
		
		Customer customer = new Customer();
		customer.setFuel(new Fuel("diesel", 50));
		customer.setMoney(1_000_000);
		
		customer.buy(gasStation, "diesel", 50);
		
		System.out.println(gasStation);
		System.out.println(customer);
		
	}
	

}
