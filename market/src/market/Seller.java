package market;

/**
 * 판매자
 * @author User
 *
 */
public class Seller {
	
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
	 * 판매
	 * (buyer에게 orderQty만큼 판매한다)
	 * @param orderQty 판매개수
	 */
	public void sell(int orderQty) {
			this.stock = this.stock - orderQty;
	}
	
	public void addMoney(int money) {
		this.money = this.money + money;
	}
	
	@Override
	public String toString() {
		return "[판매자] 재고: " + this.stock + "개, 자본금: " + this.money + "원";
	}

}
