package address_book;

import java.util.ArrayList;
import java.util.List;

public class AddressListHandler {
	
	private List <Address> addressList = new ArrayList<>();
	
	public void create (String name, String phoneNumber, String address) {
		Address addr = new Address();
		addr.setName(name);
		addr.setAddress(address);
		addr.setPhoneNumber(phoneNumber);
		addressList.add(addr);
	}
	
	public void update (int index, String name, String phoneNumber, String address) {
		Address addr = addressList.get(index);
		addr.setName(name);
		addr.setPhoneNumber(phoneNumber);
		addr.setAddress(address);
	}
	
	public void delete (int index) {
		addressList.remove(index);
	}
	
	public void read (int index) {
		Address addr = addressList.get(index);
		System.out.println("이름: " + addr.getName());
		System.out.println("전화번호: " + addr.getAddress());
		System.out.println("주소: " + addr.getPhoneNumber());
	}
	
	
	/**
	 * 전통적 for를 이용해 반복
	 */
	public void readAllFor() {
		for (int i = 0; i < addressList.size(); i += 1) {
			read(i);
		}
	}
	
	/**
	 * for-each를 이용해 반복
	 */
	public void readAllForeach() {
		for (Address addr: addressList) {
			System.out.println("이름: " + addr.getName());
			System.out.println("전화번호: " + addr.getAddress());
			System.out.println("주소: " + addr.getPhoneNumber());
		}
	}
	
	/**
	 * 람다를 이용한 for-each 반복
	 */
	public void readlAllListForeach() {
		addressList.forEach((addr) -> {
			System.out.println("이름: " + addr.getName());
			System.out.println("전화번호: " + addr.getAddress());
			System.out.println("주소: " + addr.getPhoneNumber());
		});
	}
	
	public static void main(String[] args) {
		AddressListHandler handler = new AddressListHandler();
		
		handler.create("호두", "010-1111-2222", "서울");
		handler.create("땅콩", "010-2222-2342", "경기");
		handler.create("캐슈넛", "010-2722-2911", "강원");
		
		handler.read(0);
		handler.read(1);
		handler.read(2);
		
		handler.update(2, "버터", "010-5555-5222", "부산");
		handler.read(2);
		
		handler.delete(1);
		
		System.out.println("========FOR=========");
		
		handler.readAllFor();
		
		System.out.println("========FOR-EACH=========");
		handler.readAllForeach();
		
		System.out.println("=========LIST-FOR-EACH========");
		handler.readlAllListForeach();
	}

}
