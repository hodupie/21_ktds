package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		List<String> wordList = new ArrayList<>();
		String startLetter = "";
		
		System.out.println("=====끝말잇기 시작=====");
		while (true) {
			if (startLetter.equals("")) {
				System.out.println("시작 단어를 입력하세요.");
			}
			else {
				System.out.println("\"" + startLetter + "\"" + "로 시작하는 단어를 입력하세요.");
			}
			
			String word = scan.nextLine();
			//word = word.trim();
			word = word.replace(" ", "");
			
			//1. 3글자가 아니라면
			if (word.length() < 3) {
				if (!word.startsWith(startLetter) || word.equals("포기")) {
					System.out.println("\"" + word + "\"" + "를 입력했습니다.");
					System.out.println("게임이 종료됩니다.");
					break;
				}
				System.out.println("\"" + word + "\"" + "는 " + word.length() + "글자입니다. 3글자 이상의 단어를 입력하세요.");
			}
			
			//2. 3글자는 넘지만 시작 단어와 다르거나 포기를 입력한다면
			else if (!word.startsWith(startLetter) || word.equals("포기")) {
				System.out.println("\"" + word + "\"" + "를 입력했습니다.");
				System.out.println("게임이 종료됩니다.");
				break;
			}
			
			//3. 올바를 끝말잇기 단어를 입력한다면
			else {
				wordList.add(word);
				startLetter = word.substring(word.length() - 1);
			}
		}
		
		System.out.println("입력한 단어들은");
		for (String words: wordList) {
			System.out.println(words);
		}
		System.out.println("입니다.");
	}
}
