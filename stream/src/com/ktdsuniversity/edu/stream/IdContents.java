package com.ktdsuniversity.edu.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
		
		
	}

}
