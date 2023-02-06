package assignment;

public class Q20_Product {
	
	private String name;
	
	private int price;
	
	private int stock;

	public Q20_Product (String name, int price, int stock) {
		setName(name);
		setPrice(price);
		setStock(stock);
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	

}
