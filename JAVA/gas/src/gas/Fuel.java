package gas;

/**
 * 연료
 * @author User
 */
public class Fuel {
	
	private FuelType type;
	/*
	 * 연료 잔량
	 */
	private int stock;
	
	public FuelType getType() {
		return type;
	}
	
	public void setType(FuelType type) {
		this.type = type;
	}
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void add(int amount) {
		stock += stock;
	}
	
	public void substrack(int amount) {
		stock -= stock;
	}
	
	Fuel() {
		
	}
	
	Fuel(FuelType type){
		this.type = type;
	}
	
	
	Fuel(FuelType type, int stock) {
		this.type = type;
		this.stock = stock;
	}
	
	
	@Override
	public String toString() {
		return type + ": " + stock;
	}


}
