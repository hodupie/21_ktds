package com.ktdsuniversity.edu.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class IdContents {

	public static List<IdContentsVO> readTextFile() {

		try {
			List<IdContentsVO> list = Files.readAllLines(Paths.get("C:\\Devs\\data\\data\\10K.ID.CONTENTS"))
									 .parallelStream()
									 .map((line) -> {
										 String[] strArr = line.split("\t");
										 IdContentsVO vo = new IdContentsVO();
										 vo.setKey(strArr[0].trim());
										 if (strArr.length >= 2) {
											 vo.setValue(strArr[1].trim());
										 }
										 return vo;
									 })
									 .collect(Collectors.toList());
				return list;

		} catch (IOException ioe) {
			return new ArrayList<>();
		}
	}
	
	public static void main(String[] args) {
		List<IdContentsVO> list = readTextFile();
		System.out.println(list.size());
		
		
		System.out.println("============8-1==============");
		// 8-1. 10K.ID.CONTENTS 파일에서 "12370584"의 내용을 출력
		System.out.println("==1== : 추출 없이 출력");
		list.stream()
			.filter( (vo) -> vo.getKey().equals("12370584"))
			.forEach( (vo) -> {
				 System.out.println(vo.getValue());
			});
		
		System.out.println("==2== : list로 만들어 추출 후 출력");
		List<String> contents2 = list.stream()
									 .filter( (vo) -> vo.getKey().equals("12370584"))
									 .map( (vo) -> vo.getValue())
									 .collect(Collectors.toList());
		contents2.forEach(System.out::println);

		System.out.println("==3== : findFirst orElse 사용");
		IdContentsVO contents3 = list.stream()
									 .filter( (vo) -> vo.getKey().equals("12370584"))
									 .findFirst()
									 .orElse(new IdContentsVO());
		System.out.println(contents3.getValue());
		
		
		System.out.println("==4== :  Optional로 출력");
		long startTime = System.currentTimeMillis();
		
		Optional <String> contents4 = readTextFile().stream()
												.filter(vo -> vo.getKey().equals("12370584"))
												.map(vo -> vo.getValue())
												.findFirst();
		System.out.println(contents4.orElse("없음"));
		System.out.println("8-1 실행시간: " + (System.currentTimeMillis() - startTime));
		
		
		System.out.println("=================8-2================");
		// 8-2. (병렬) 10K.ID.CONTENTS 파일에서 "12370584"의 내용을 출력
		list.parallelStream()
			.filter( (vo) -> vo.getKey().equalsIgnoreCase("12370584"))
			.forEach( (vo) -> {
				System.out.println(vo.getValue());
			});
		
		List <String> contents5 = list.parallelStream()
									  .filter( vo -> vo.getKey().equals("12370584"))
									  .map( vo -> vo.getValue())
									  .collect(Collectors.toList());
		contents5.forEach(System.out::println);
		
		System.out.println("=====another=====");
		startTime = System.currentTimeMillis();
		contents4 = readTextFile().parallelStream()
							  .filter( vo -> vo.getKey().equals("12370584"))
							  .map( vo -> vo.getValue())
							  .findFirst();
		System.out.println(contents4.orElse("없음"));
		System.out.println("8-1 실행시간: " + (System.currentTimeMillis() - startTime));
		
		//9. (병렬) 10K.ID.CONTENTS 파일에서 "7670637"에 몇 개의 단어가 있는지 출력
		
		Optional<Integer> wordCount = list.parallelStream()
							.filter(vo -> vo.getKey().equals("7670637"))
							.map(vo -> vo.getValue().split(" ").length)
							.findFirst();
		System.out.println(wordCount.orElse(0));
		

		System.out.println("=============10============");
		//10. (병렬) 10K.ID.CONTENTS 파일에서 내용이 없는 "번호"는 몇 개인지 출력
		
		// 문자열 null 검사: boolean isEmpty = abc == null || abc.length() == 0;			  -> abc = " " => false
		//				  boolean isEmpty = abc == null	|| abc.trim().length() == 0;  	  -> abc = " " => true
		//				  boolean isEmpty = abc.trim().length() == 0 || abc == 0;		  -> NullPointerException
		// &&연산은 비어있음 확인 불가 -> boolean isEmpty = !(abc != null && abc.trim().length() > 0); 으로
		
		
		long nullCount = list.parallelStream()
							 //value가 null이거나 value의 값을 trim한 결과 길이가 0보다 작은 경우
							 .filter(vo -> vo.getValue() == null || vo.getValue().trim().length() < 0)
							 .map(vo -> vo.getKey())
							 .count();
		System.out.println(nullCount);
		

		//11. (병렬) 10K.ID.CONTENTS 파일에서 두 개의 단어로만 이루어진 "번호"는 몇 개인지 출력
		
		long twoWords = list.parallelStream()
							.filter(vo -> vo.getValue() != null)
							.filter(vo -> vo.getValue().split(" ").length == 2)
							.map(vo -> vo.getKey())
							.count();
		System.out.println(twoWords);
		
		//12. (병렬) 10K.ID.CONTENTS 파일에서 내용에 "that"이 포함된 글은 몇 개인지 출력
		
		long thatWord = list.parallelStream()
							.filter(vo -> vo.getValue() != null)
							.filter(vo -> vo.getValue().contains("that"))
							.count();
		System.out.println(thatWord);
		
		//13. (병렬) 10K.ID.CONTENTS 파일에서 글 번호가 6자리인 것은 몇 개인지 출력
		
		long sixKey = list.parallelStream()
						  .filter(vo -> vo.getValue() != null)
						  .filter(vo -> vo.getKey().length() == 6)
						  .count();
		System.out.println(sixKey);
		
		//14. (병렬) 10K.ID.CONTENTS 파일에서 글 번호가 7자리인 것은 몇 개인지 출력
		
		long sevenKey = list.parallelStream()
							.filter(vo -> vo.getValue() != null)
							.filter(vo -> vo.getKey().length() == 7)
							.count();
		System.out.println(sevenKey);
		
		//15. (병렬) 10K.ID.CONTENTS 파일에서 글 번호가 9로 시작하는 모든 글들의 첫 번째 단어만 출력 (map 최소 두번, filter null check X)
		
		list.parallelStream()
			.filter(vo -> vo.getKey().startsWith("9"))
			.map(vo -> {
				//key가 9로 시작하는 value의 값이 null이면 공백 return / null이 아니면 value return
				if (vo.getValue() == null) {
					return "";
				}
				return vo.getValue().trim();
			})
			.map(desc -> {
				//map한 데이터가 null이라면 
				if (desc.trim().contains("")) {
					return desc.trim().split(" ")[0];
				}
				return "";
			})
			.forEach(word -> {
				System.out.println(word);
			});
		
		
		
		System.out.println("===========================================");		
		list.parallelStream()
			.filter(vo -> vo.getKey().startsWith("9"))
			.map (vo -> {
				//value가 null이 아니고 0보다 크다면
				if (vo.getValue() != null && vo.getValue().trim().length() > 0) {
					//띄어쓰기로 split한 값의 0번째 return
					return vo.getValue().trim().split(" ")[0];
				}
				//value가 null이면 공백 출력
				return "";
			})
			.forEach(word -> {
				System.out.println(word);
			});
		System.out.println("================16===========================");
		//16. (병렬) 10K.ID.CONTENTS 파일에서 내용이 있으면 글 번호가 7로 시작하는 모든 글들의 첫번째 단어만 출력
		list.parallelStream()
			.filter(vo -> vo.getValue() != null)
			.filter(vo -> vo.getKey().startsWith("7"))
			.map(vo -> {
					if (vo.getValue() != null && vo.getValue().trim().length() > 0) {
						return vo.getValue().trim().split(" ")[0];
					}
					return "";
			})
			.forEach(vo -> {
				System.out.println(vo);
			});
		
	}

}
