package gas;

public class Customer {
	
	/**
	 * 연료
	 */
	private Fuel fuel;
	
	/**
	 * 고객이 가진 돈
	 */
	private int money;
	
	public Customer(Fuel fuel, int money) {
		this.fuel = fuel;
		this.money = money;
	}
	
	public Fuel getFuel() {
		return fuel;
	}

	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
	}

	/**
	 * 주유소에서 연료를 구입한다.
	 * @param gasStation 주유소
	 * @param type 연료 종류 (GASOLINE, DIESEL, LPG)
	 * @param amount 구매량
	 */
	public void buy(GasStation gasStation, FuelType type, int amount) {
//		1. 돈이 없다면 "잔액이 부족합니다"를 출력하고 buy 메소드 종료
//		2. 연료재고가 있다면 (gasStation.sell이 true라면)
//			연료의 잔량을 amount만큼 증가시키고
//			금액 지불 (pay)
		
		double totalPrice = amount * GasStation.PRICES.get(type);
		
		if (!checkMoney(totalPrice)) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		
		if (gasStation.sell(type, amount) ) {
			fuel.add(amount);
			pay(gasStation, totalPrice);
		}
	}
			
	
	/**
	 * 지출
	 * @param gasStation 주유소
	 * @param totalPrice 구매가격
	 */
	private void pay(GasStation gasStation, double totalPrice) {
		gasStation.addMoney(totalPrice);
		money -= totalPrice;
	}
	
	/**
	 * 주유하기에 충분한 돈을 가지고 있는지 확인한다.
	 * @return 주유가 가능한 돈을 가지고 있다면 true, 아니면 false
	 */
	private boolean checkMoney(double totalPrice) {
		return money >= totalPrice;
	}
		

	@Override
	public String toString() {
		return "[고객 현황]\n" + fuel + "\n소지금: " + money;
	}
	
	

}
