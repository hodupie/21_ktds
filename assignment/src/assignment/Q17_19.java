package assignment;


public class Q17_19 {
	
	public static int card(boolean youth, int money) {
		if (youth == true) {
			money -= 900;
		}
		else {
			money -= 1300;
		}
		return money;
	}
	
	
	public static void main(String[] args) {
		System.out.println("=====문제17=====");
		
		int age = 28;
		boolean youth = false;
		
		if (age < 19) {
			youth = true;
			System.out.println("미성년자입니다.");
		}
		else { System.out.println("성인입니다.");;
		}
		
		System.out.println("=====문제18====");
		if (7 <= age && age <= 13) {
			System.out.println("초등학생입니다.");
		}
		else if (14 <= age && age <= 16) {
			System.out.println("중학생입니다.");
		}
		else if (17 <= age && age <= 19) {
			System.out.println("고등학생입니다.");
		}
		else {
			System.out.println("학생이 아닙니다.");
		}
		
		System.out.println("=====문제19=====");
		int money = 5000;
		System.out.println(card(youth, money));

	}
}
