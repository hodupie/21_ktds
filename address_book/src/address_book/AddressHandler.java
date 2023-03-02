package address_book;

public class AddressHandler {
	
	private Address address1;
	
	/**
	 * 주소록 추가
	 */
	public void create() {
		address1 = new Address();
		address1.setName("호두");
		address1.setPhoneNumber("010-1234-5678");
		address1.setAddress("서울");
	}
	
	/**
	 * 주소록 수정
	 */
	public void update() {
		address1.setName("땅콩");
		
	}
	
	/**
	 * 주소록 삭제
	 */
	public void delete() {
		address1 = null;
	}
	
	/**
	 * 주소록 조회
	 */
	public void read() {
		System.out.println("이름: " + address1.getName());
		System.out.println("전화번호: " + address1.getPhoneNumber());
		System.out.println("주소: " + address1.getAddress());
	}
	
	public static void main(String[] args) {
		
		AddressHandler handler = new AddressHandler();
		
		handler.create();
		handler.read();
		
		handler.update();
		handler.read();
		
		handler.delete();
		
	}

}
