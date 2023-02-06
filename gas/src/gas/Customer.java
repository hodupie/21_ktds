package gas;

public class Customer {
	
	/**
	 * 연료
	 */
	private Fuel fuel;
	
	/**
	 * 자본금
	 */
	private int money;

	public Fuel getFuel() {
		return fuel;
	}

	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	/**
	 * 주유소에서 연료를 구입한다.
	 * @param gasStation 주유소
	 * @param type 연료 종류 (gasolin, diesel, lpg)
	 * @param stock 구매량
	 */
	public void buy(GasStation gasStation, String type, int stock) {
//		1. type 연료를 stock만큼 구매할 돈이 있는지 확인한다.
//		1-1. 돈이 있다면 연료의 잔량을 stock만큼 증가시킨다.
//		1-2. 돈이 없다면 "연료를 구매할 수 없습니다"를 출력하고 메소드를 끝낸다.
//		1-3. 돈은 있는데 주유소에서 판매할 수 없다고 하면 "연료를 구매할 수 없습니다"를 출력하고 메소드를 끝낸다.
		
		if (checkMoney(type, stock)) { 								//돈이 있다면
			boolean sellResult = gasStation.sell(type, stock);		//주유소에서 연료 판매가 가능한지 (연료가 남았는지) 확인
			
			if (sellResult) {										//연료 채우기
				int fuelStock = fuel.getStock();
				fuelStock += stock;
				fuel.setStock(fuelStock);
				
				int money = Street.PRICES.get(type);
				if (type.equals("gasolin")) {
					money = (int) Street.GASOLIN_PRICE * stock;
				}
				else if (type.equals("diesel")) {
					money = (int) Street.DIESEL_PRICE * stock;
				}
				else if (type.equals("lpg")) {
					money = (int) Street.LPG_PRICE * stock;					
				}
				this.pay(gasStation, money);						//지불
			}
			
			else {
				System.out.println("주유소에 연료가 없어 구매할 수 없습니다.");
			}
			
		}
		
		else {
			System.out.println("돈이 없어 연료를 구매할 수 없습니다.");
		}
		
	}
	
	/**
	 * 지출
	 * @param gasStation 주유소
	 * @param money 구매가격
	 */
	private void pay(GasStation gasStation, int money) {
		gasStation.addMoney(money);
		this.money -= money;
	}
	
	/**
	 * 주유하기에 충분한 돈을 가지고 있는지 확인한다.
	 * @param type 주유할 연료 종류 (gasolin, diesel, lpg)
	 * @param stock 주유량
	 * @return 주유가 가능한 돈을 가지고 있다면 true, 아니면 false
	 */
	private boolean checkMoney(String type, int stock) {
		boolean result = false;
		
		if (type.equals("gasolin")) {
			//type에 맞는 연료 가격을 stock과 곱해서 money보다 적은지 확인한다.
			result = Street.GASOLIN_PRICE * stock <= money;
		}
		
		else if (type.equals("diesel")) {
			result = Street.DIESEL_PRICE * stock <= money;			
		}
		
		else if (type.equals("lpg")) {
			result = Street.LPG_PRICE * stock <= money;
		}
		return result;
	}

	@Override
	public String toString() {
		return "Customer [" + fuel + " money: " + money + "]";
	}
	
	

}
