package address_book;

/**
 * 주소 관리 클래스
 * @author User
 *
 */
public class Address {
	
	/**
	 * 이름
	 */
	private String name;
	
	/**
	 * 전화번호
	 */
	private String phoneNumber;
	
	/**
	 * 주소
	 */
	private String address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
