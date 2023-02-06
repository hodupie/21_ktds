package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyGameTryCatch {
	
	
	public static void checkWord(String word, String startLetter) {
		// 1. 단어의 첫글자가 맞지 않거나 "포기"를 입력하면 -> 오류를 WrongWordException으로 throw
		if (!word.startsWith(startLetter) || word.equals("포기")) {
			throw new WrongWordException();
		}
		
		// 2. 3글자가 아니라면 -> 오류를 InvalidWordException으로 throw
		else if (word.length() < 3) {
			throw new InvalidWordException();
		}
	}
	
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
			
			try {
				checkWord(word, startLetter);
				wordList.add(word);
				startLetter = word.substring(word.length() - 1);
			} catch (InvalidWordException iwe) {	//InvalideWordException에 대한 catch
				System.out.println("\"" + word + "\"는 " + word.length() + "자리 단어입니다. 3자리 이상의 단어를 입력하세요.");
			} catch (WrongWordException wwe) {		//WrongWordException에 대한 catch
				System.out.println("\"" + word + "\"" + "를 입력했습니다. 게임을 종료합니다.");
				break;								//while 탈출
			}
		
		}
		
		System.out.println("입력한 단어들은");
		for (String words: wordList) {
			System.out.println(words);
		}
		System.out.println("입니다.");
	}
}

