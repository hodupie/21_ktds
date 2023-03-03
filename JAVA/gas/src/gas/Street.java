package gas;

import java.util.ArrayList;
import java.util.List;

public class Street {
	
	public static void main(String[] args) {
		GasStation gasStation  = new GasStation();
		
		List<Customer> customers =  new ArrayList<>();
		
		customers.add(new Customer(new Fuel(FuelType.GASOLINE, 20), 1_000_000));
		customers.add(new Customer(new Fuel(FuelType.DIESEL,50),1_000_000));
		customers.add(new Customer(new Fuel(FuelType.LPG),1_000_000));

		
		for(Customer customer: customers) {
			FuelType type = customer.getFuel().getType();
			customer.buy(gasStation, type, 20);
		}
		
		for(Customer customer: customers) {
			System.out.println(customer);
		}
		
		System.out.println(gasStation);
	}
	
}
