package assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Q20_Store {
	
	Random rd = new Random();
	
	private int money;
	
	private static List<Q20_Product> productList;

	public Q20_Store () {
		productList = new ArrayList<>();
	}
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public List<Q20_Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Q20_Product> productList) {
		this.productList = productList;
	}

	public void add () {
		for (int i = 0; i < 10; i++) {
			String name = "P" + Integer.toString(i);
			int price = rd.nextInt(100) * 100;
			int stock = rd.nextInt(20);
			productList.add(new Q20_Product(name, price, stock));
		}
	}
	
	public void sell (int order) {
		
		getstock -= order;
		money += price;
	}

	public void refund (int refund) {
		stock += order;
		money -= price;
	}
	
	public static void main(String[] args) {
		Q20_Store store = new Q20_Store();
		store.add();
		for (Q20_Product product : productList) {
			System.out.println(product.getName());
			System.out.println(product.getPrice());
			System.out.println(product.getStock());
		}
	}
}
