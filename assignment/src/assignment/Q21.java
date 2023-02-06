package assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Q21 {
	
	public static void main(String[] args) {
		Random random = new Random();
		List <Integer> lotto = new ArrayList<>();
		
		for (int i = 0; i < 6; i++) {
			int number = random.nextInt(45) + 1;
			System.out.println(number);
			if (lotto.contains(number)) {
				i -= 1;
				continue;
			}
			else {
				lotto.add(number);
			}
		}
		System.out.println(lotto);
	}
}
