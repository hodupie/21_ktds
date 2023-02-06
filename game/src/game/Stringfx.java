package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stringfx {

	public static void main(String[] args) {
		String str = "			값 값 값 			";
		System.out.println("기존 값:\t" + "[" + str + "]");
		//문자열에서 좌우공백 제거하기 .trim
		str = str.trim();
		System.out.println("변경된 값:\t" + "[" + str + "]");
		//문자열에서 텍스트 변경하기 .replace / .replaceAll
		str = str.replace(" ", "_");
		System.out.println("변경된 값:\t" + "[" + str + "]");
		
		str = str.replaceAll("_", "-");
		System.out.println("변경된 값:\t" + "[" + str + "]");
		
		//.replaceAll은 정규표현식([범위지정자]) 사용 가능
		//모든 한글을 ""으로 변경
		str = "<html>HTML 문서를 작성합니다. </html>";
		str = str.replaceAll("[가-힣]", "");
		System.out.println("변경된 값:\t" + "[" + str + "]");
		
		//([^범위지정자]): 범위지정자 빼고
		str = "<html>HTML 문서를 작성합니다. </html>";
		str = str.replaceAll("[^가-힣]", "");
		System.out.println("변경된 값:\t" + "[" + str + "]");
	
		str = "<html>HTML 문서를 작성합니다. </html>";
		str = str.replaceAll("[^a-zA-Z]", "");
		System.out.println("변경된 값:\t" + "[" + str + "]");
		
		str = "핸드폰 번호는 010-1234-5678 입니다.";
		str = str.replaceAll("[^0-9]", "");
		System.out.println("변경된 값:\t" + "[" + str + "]");
		//문자열에서 특정 단어로 시작하는지 확인하기 .indexOf
		str = "자전거";
		System.out.println("자 의 자리: " + str.indexOf("자"));
		System.out.println("전 의 자리: " + str.indexOf("전"));
		System.out.println("거 의 자리: " + str.indexOf("거"));
		System.out.println("기 의 자리: " + str.indexOf("기"));
		if (str.indexOf("자") == 0) {
			System.out.println("자전거는 \"자\"로 시작합니다.");
		}
		//문자열에서 특정 단어로 시작하는지 확인하기 .startsWith
		System.out.println("자전거는 \"자\"로 시작하나요? " + str.startsWith("자"));
		System.out.println("자전거는 \"전\"로 시작하나요? " + str.startsWith("전"));
		System.out.println("자전거는 \"거\"로 시작하나요? " + str.startsWith("거"));
		//문자열에서 특정 단어로 끝나는지 확인하기 .lastIndexOf
		str = "기러기";
		System.out.println("기러 \"기\"의 자리는? (indexof) " + str.indexOf("기"));
		System.out.println("기러 \"기\"의 자리는? (lastindexof) " + str.lastIndexOf("기"));
		
		System.out.println(str.length());
		System.out.println("기러기는 \"기\"로 끝나나요? " + (str.lastIndexOf("기") == str.length() - 1));
		//문자열에서 특정 단어로 끝나는지 확인하기 .endsWith
		System.out.println("거중기는 \"거\"로 끝나나요? " + str.endsWith("거"));
		System.out.println("거중기는 \"중\"로 끝나나요? " + str.endsWith("중"));
		System.out.println("거중기는 \"기\"로 끝나나요? " + str.endsWith("기"));
		//문자열에 특정 단어 및 글자가 포함되어 있는지 확인하기 .indexOf
		str = "자전거";
		System.out.println("자전거에는 \"자\"가 포함되어 있나요? " + (str.indexOf("자") > -1));
		System.out.println("자전거에는 \"전\"가 포함되어 있나요? " + (str.indexOf("전") > -1));
		System.out.println("자전거에는 \"거\"가 포함되어 있나요? " + (str.indexOf("거") > -1));
		System.out.println("자전거에는 \"기\"가 포함되어 있나요? " + (str.indexOf("기") > -1));
		//문자열에 특정 단어 및 글자가 포함되어 있는지 확인하기 .contains
		System.out.println("자전거에는 \"기\"가 포함되어 있나요? " + str.contains("자"));
		System.out.println("자전거에는 \"기\"가 포함되어 있나요? " + str.contains("전"));
		System.out.println("자전거에는 \"기\"가 포함되어 있나요? " + str.contains("거"));
		System.out.println("자전거에는 \"기\"가 포함되어 있나요? " + str.contains("기"));
		
		//문자열 자르기 .substring(p)
		str = "2023-02-23";
		String day = str.substring(8); //8부터 끝까지 자르기
		System.out.println(day);
		
		String date = str.substring(5);
		date = date.replace("-", "");
		System.out.println(date);
		
		//문자열 자르기 .substring(p, p) -> end + 1
		str = "2023-02-03 11:01:15";
		String year = str.substring(0, 4);
		String hour = str.substring(11, 13);
		String minute = str.substring(14, 16);
		String second = str.substring(17, 19);
		System.out.println(year);
		System.out.println(hour);
		System.out.println(minute);
		System.out.println(second);
		
		//문자열 특정 단어 및 기호 등으로 자르기 .split -> 배열 return
		str = "자전거, 거중기, 기러기";
		List<String> wordList = Arrays.asList(str.split(",")); 	//배열을 list로
		for (String word: wordList) {
			System.out.println(word.trim());
		}
		
		str = "2023-02-03 11:22:34";
		List<String> dateList = Arrays.asList(str.split("[- :]"));
		for (String dateItem: dateList) {
			System.out.println(dateItem);
		}
		
		System.out.println("==============================================");
		//substring과 indexOf로만
		String url = "https://www.google.co.kr";
		
		System.out.println(url.indexOf("://"));		//"://"가 시작되는 인덱스 return
		String protocol = url.substring(0, url.indexOf("://"));
		System.out.println("Protocol:\t" + protocol);
		
		System.out.println(url.indexOf("."));
		String subDomain = url.substring(url.indexOf("://") + "://".length(), url.indexOf("."));
		System.out.println("Sub domain:\t" + subDomain);
		
		String domain = url.substring(url.indexOf(subDomain) + subDomain.length() + ".".length());
		domain = domain.substring(0, domain.indexOf("."));
		System.out.println("Domain:\t\t" + domain);
		
		String companyCode = url.substring(url.indexOf(domain) + domain.length() + ".".length());
		companyCode = companyCode.substring(0, companyCode.indexOf("."));
		System.out.println("Company Code:\t" + companyCode);
				
		String nationCode = url.substring(url.lastIndexOf(".") + ".".length());
		System.out.println("Nation Code:\t" + nationCode);

//		String nationCode = url.substring(url.indexOf(companyCode) + companyCode.length() + ".".length());
//		System.out.println(nationCode);
		
		List<String> urlList = Arrays.asList(url.split("[:// .]"));
		System.out.println(urlList);
		System.out.println("=====");
		urlList.remove("");
		
		List<String> urlList2 = new ArrayList<>(Arrays.asList(url.split("[:// .]")));
		urlList2.removeIf(e -> e.isEmpty());
		
//		for (int i = 0; i < urlList.size(); i++) {
//			System.out.println(urlList.get(i));
//			if (urlList.get(i).equals(" ")) {
//				System.out.println("null");
//				urlList.remove(i);
//			}
//		}
		System.out.println(urlList2);
	}
}


