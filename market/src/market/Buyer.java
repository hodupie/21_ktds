package market;

/**구매자
 * 
 * @author User
 *
 */
public class Buyer {
	
	/**
	 * 재고
	 */
	private int stock;
	
	/**
	 * 자본금
	 */
	private int money;

	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	/**
	 * 주문
	 * (seller에게 orderQty만큼 주문한다)
	 * @param seller 판매자
	 * @param orderQty 주문개수
	 */
	public void buy(Seller seller, int orderQty) {
		seller.sell(orderQty);
		this.stock = this.stock + orderQty;
		this.pay(seller, orderQty);
	}
	
	/**
	 * 지불
	 * (Seller에게 (orderQty * 시장판매가) 만큼을 지불한다)
	 * @param seller 판매자
	 * @param orderQty 주문개수
	 */
	public void pay(Seller seller, int orderQty) {
		this.money = this.money - (orderQty * Market.PRICE_OF_APPLE);
		seller.addMoney(orderQty * Market.PRICE_OF_APPLE);
	}
	
	@Override
	public String toString() {
		return "[구매자] 재고: " + this.stock + "개, 자본금: " + this.money + "원";
	}

}
