package market;

public class Market {
	
	/**
	 * 사과 시장 가격
	 */
	public static final int PRICE_OF_APPLE = 2_000; //상수
	
	public static void main(String[] args) {
		
		Buyer buyer = new Buyer();
		Seller seller = new Seller();
		
		buyer.setStock(0);
		buyer.setMoney(1_000_000);
		
		seller.setStock(50);
		seller.setMoney(10_000);
		
		buyer.buy(seller, 5);
		
		System.out.println(buyer);
		System.out.println(seller);
		
	}

}
