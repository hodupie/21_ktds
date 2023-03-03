package gas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GasStation {
	public static final Map<FuelType, Double> PRICES;
	
	static {
		PRICES = new HashMap<>();
		PRICES.put(FuelType.GASOLINE, 1569.67);
		PRICES.put(FuelType.DIESEL, 1651.15);
		PRICES.put(FuelType.LPG, 1039.35);
	}
	
	
	private List <Fuel> fuelList;
	private int money;
	
	//생성자
	public GasStation() {
		fuelList = new ArrayList<>();
		fuelList.add(new Fuel(FuelType.GASOLINE, 5_000));
		fuelList.add(new Fuel(FuelType.DIESEL, 3_000));
		fuelList.add(new Fuel(FuelType.LPG, 1_000));
		
		setMoney(1_000_000);
	}
	
	// FuelType의 연료 타입을 인덱스(int)로 가져옴
	public Fuel getFuelList(int type) {
		return fuelList.get(type);
	}
	
	public void setFuelList(int type, Fuel fuel) {
		fuelList.set(type, fuel);
	}
	
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	/**
	 * 판매
	 * @param type 연료 종류 (gasolin, diesel, lpg)
	 * @param amount 판매량
	 */
	public boolean sell(FuelType type, int amount) {
		boolean result = false;
//		1. type 연료가 amount만큼 존재하는지 확인한다.
//		1-1. 연료가 충분하다면(true)  type 연료의 잔량을 stock만큼 줄인다.
//		1-2. 연료가 부족하다면(false) "연료가 부족합니다"를 출력하고 메소드를 종료한다.
		if (checkStock(type, amount)) {
			// .ordinal(): enum(Fuel)의 객체 순번 return
			fuelList.get(type.ordinal()).substrack(amount);
			result = true;
		}
		
		else {
			result = false;
			System.out.println("연료 재고가 부족합니다.");
		}
		
		return result;
	}

	/**
	 * 수입
	 * @param totalPrice 총 구매가격
	 */
	public void addMoney(double totalPrice) {
		money += totalPrice;
	}

	/**
	 * type 연료가 amount만큼 주유 가능한지 확인
	 * @param type 연료종류
	 * @param amount 원하는 주유량
	 * @return 연료의 재고가 amount 이상이면 true, 아니면 false
	 */
	private boolean checkStock(FuelType type, int amount) {
		// .ordinal(): enum(Fuel)의 객체 순번 return
		return fuelList.get(type.ordinal()).getStock() >= amount;
	}
	
	
	@Override
	public String toString() {
		return "[주유소 재고 현황] \n" + fuelList + "\n자본금: " + money + "원";
	}
	
	
}
