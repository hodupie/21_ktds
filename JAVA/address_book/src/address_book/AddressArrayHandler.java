package address_book;

/**
 * 주소를 최대 5개만 저장할 수 있는 주소록
 * @author User
 */
public class AddressArrayHandler {
	
	//배열 정의방법: 타입[] 변수명 = new 타입[몇개?];
	
	private Address[] addressArray = new Address[5]; //addressArray라는 5개짜리 배열 틀 만들기
	
	public void create (int index, String name, String phoneNumber, String address) {
		addressArray[index] = new Address();
		addressArray[index].setName(name);
		addressArray[index].setPhoneNumber(phoneNumber);
		addressArray[index].setAddress(address);
	}
	
	public void update (int index, String name, String phoneNumber, String address) {
		addressArray[index].setName(name);
		addressArray[index].setPhoneNumber(phoneNumber);
		addressArray[index].setAddress(address);		
	}
	
	public void delete (int index) {
		addressArray[index] = null;
	}
	
	public void read (int index) {
		
		if (addressArray.length > index) {
			System.out.println("이름: " + addressArray[index].getName());
			System.out.println("전화번호: " + addressArray[index].getPhoneNumber());
			System.out.println("주소: " + addressArray[index].getAddress());
		}
	}
	
	public static void main(String[] args) {
		
		AddressArrayHandler handler = new AddressArrayHandler();
		handler.create(0, "김", "010-1234-5678", "서울");
		handler.create(1, "이", "010-0987-5432", "충남");
		handler.create(2, "박", "없음", "캘리포니아");
		handler.create(3, "최", "010-2726-2725", "프랑스");
		handler.create(4, "정", "010-1111-2222", "서울");
		
		handler.read(0);
		handler.read(1);
		handler.read(2);
		handler.read(3);
	}
}
