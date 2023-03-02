package loop;

import java.util.Random;
import java.util.Scanner;

public class Q22 {
	
	public static void main(String[] args) {
		Random rd = new Random();
		int num = rd.nextInt(100);
		System.out.println(num);
		Scanner scan = new Scanner(System.in);
		
		int input;
		while (true) {
			System.out.println("숫자 입력: ");
			input = scan.nextInt();
			if (input == num) {
				System.out.println("정답입니다.");
				break;
			}
			else if (input < num) {
				System.out.println("UP");
				continue;
			}
			else {
				System.out.println("DOWN");
				continue;
			}
		}
	}
}

