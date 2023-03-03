package store;

/**
 * 실행 클래스
 * @author User
 *
 */
public class Main {
	Store store = new Store();
	
	public static void main(String[] args) {
		
		// Main 인스턴스화 (static으로 인해 클래스 필드가 되어버렸음 -> 인스턴스 필드에 있는 store를 사용하기 위해)
		Main main = new Main();
		main.store.addProducts();
		main.store.checkQunatity();
		
//		//편의점 변수(인스턴스 | 객체)
//		store.addProducts();
//		store.checkQunatity();
		
		try {
			int number = Integer.parseInt("ABC");
		}
		catch (NumberFormatException e) {
			System.out.println("에러가 발생했습니다 " + e.getMessage());
			e.printStackTrace ();	
		}
		System.out.println("예외처리");
	}

}
