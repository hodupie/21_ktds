package com.ktdsuniversity.edu.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballStream1 {

	public static List<AllStarFullVO> readAllStarFull() {
//0
		try {
			List<AllStarFullVO> list = Files.readAllLines(Paths.get("C:\\Devs\\data\\baseball\\core\\AllstarFull.csv"))
					.stream().skip(1) // 첫번째 라인 건너뛰기
//											.peek(System.out::println)		//중간 확인
					.map((line) -> {
						String[] strArr = line.split(",");
						AllStarFullVO vo = new AllStarFullVO();
						vo.setPlayerID(strArr[0]);
						vo.setYear(strArr[1]);
						vo.setGameNum(Integer.parseInt(strArr[2]));
						vo.setGameID(strArr[3]);
						vo.setTeamID(strArr[4]);
						vo.setLgID(strArr[5]);
						vo.setGp(Integer.parseInt(strArr[6]));
						if (strArr.length == 8) {
							vo.setStartingPos(Integer.parseInt(strArr[7]));
						} else {
							vo.setStartingPos(0);
						}
						return vo;
					}).collect(Collectors.toList());
			return list;

		} catch (IOException ioe) {
			ioe.printStackTrace();
			return new ArrayList<>();
		}
	}

	public static void main(String[] args) {
		List<AllStarFullVO> list = readAllStarFull();
		System.out.println(list.size());

//		list.stream() // list -> stream
//				.filter((vo) -> vo.getYear().equals("1933"))
//				.forEach((vo) -> {
//					System.out.println(vo.getPlayerID());
//					System.out.println(vo.getYear());
//				});
//
//		List<AllStarFullVO> playIn1933 = list.stream()
//											.filter((vo) -> vo.getYear().equals("1933"))
//											.collect(Collectors.toList());
//		
//		AllStarFullVO vo = list.stream()
//								.filter( (vo1) -> vo1.getYear().equals("2022"))
//								.findFirst()					// 최종함수. optional: 데이터가 있으면 첫번째 값 return
//																// null값이면 orElse값 return 
////								.get();
//								.orElse(new AllStarFullVO());
//		System.out.println(vo.getPlayerID());
		
		//연도에 관계 없이 playerID가 F로 시작하는 모든 데이터 출력
		
//		list.stream()
////				.filter( (vo2) -> vo2.getPlayerID().startsWith("f") || vo2.getPlayerID().startsWith("F"))
//				.filter( (vo2) -> vo2.getPlayerID().toUpperCase().startsWith("F"))
//				.forEach( (vo2) -> {
//					System.out.println(vo2.getPlayerID());
//					System.out.println(vo2.getYear());
//				});
//		
//		list.stream()
//				.filter( (allStarVO) -> allStarVO.getYear().equals("2004"))
//				.filter( (allStarVO) -> allStarVO.getTeamID().equals("TEX"))
//				.forEach( (allStarVO) -> {
//					System.out.println(allStarVO.getPlayerID());
//					System.out.println(allStarVO.getYear());
//					System.out.println(allStarVO.getTeamID());
//				});
	
//		list.stream()
//			.filter( (allStarVO) -> allStarVO.getStartingPos() == 0)
//			.forEach( (allStarVO) -> {
//				System.out.println(allStarVO.getPlayerID());
//				System.out.println(allStarVO.getStartingPos());
//			});
		
		
//		System.out.println("=================");
//		//gp == 0, teamID == NYA, PlayerID include "fo" 
//		list.stream()
//			.filter( (allStarVO) -> allStarVO.getTeamID().equals("NYA"))
//			.filter( (allStarVO) -> allStarVO.getGp() == 0)
//			.filter( (allStarVO) -> allStarVO.getPlayerID().toLowerCase().contains("fo"))
//			.forEach( (allStarVO) -> {
//				System.out.println(allStarVO.getPlayerID());
//				System.out.println(allStarVO.getTeamID());
//				System.out.println(allStarVO.getGp());
//				System.out.println(allStarVO.getYear());
//			});
//		
//		System.out.println("=================");
//		list.parallelStream()
//			.filter( (allStarVO) -> allStarVO.getTeamID().equals("NYA"))
//			.filter( (allStarVO) -> allStarVO.getGp() == 0)
//			.filter( (allStarVO) -> allStarVO.getPlayerID().toUpperCase().contains("FO"))
//			.forEach( (allStarVO) -> {
//				System.out.println(allStarVO.getPlayerID());
//				System.out.println(allStarVO.getTeamID());
//				System.out.println(allStarVO.getGp());
//				System.out.println(allStarVO.getYear());
//			});
//		System.out.println("=================");
//		
//		List<String> playerNameList = list.stream()
//											.map( (allStarVO) -> allStarVO.getPlayerID() )		//Stream -> String(PlayerID의 타입)
//											.distinct()											//중복제거
//											.sorted()
//											.collect(Collectors.toList());
//		playerNameList.forEach(System.out::println);
//		
//		//startingPos == 4의 playerID 추출 -> 중복제거 -> 정렬 -> 출력 
//		List<String> StartingPosList = list.stream()
//											.filter( (allStarVO) -> allStarVO.getStartingPos() == 4)
//											.map ( (allStarVO) -> allStarVO.getPlayerID())
//											.distinct()
//											.sorted()
//											.collect(Collectors.toList());
//		StartingPosList.forEach(System.out::println);
		
//		//1. gameNum이 0이 아닌 것을 추출해 출력
//		list.stream()
//			.filter( (allStarVO) -> allStarVO.getGameNum() != 0)
//			.forEach( (allStarVO) -> {
//				System.out.println(allStarVO.getPlayerID());
//				System.out.println(allStarVO.getGameNum());
//			});
//		
//		System.out.println("=============");
//		
//		List<String> Q1List = list.stream()
//									.filter( (vo) -> vo.getGameNum() != 0)
//									.map( (vo) -> vo.getPlayerID())
//									.collect(Collectors.toList());
//		Q1List.forEach(System.out::println);
//		
//		//2. gameNum이 0인것 추출해 출력
//		System.out.println("=============");
//		list.stream()
//			.filter( (vo) -> vo.getGameNum() == 0)
//			.forEach( (vo) -> {
//				System.out.println(vo.getPlayerID());
//				System.out.println(vo.getGameNum());
//			});
//		
//		List<AllStarFullVO> gameNum = list.stream()
//											.filter( (vo) -> vo.getGameID())
//											.collect(Collectors.toList());
//		gameNum.forEach((vo) -> {
//			System.out.println(vo.getPlayerID());
//			System.out.println(vo.getGameNum());
//		});
		
		//3. 1950년대에 플레이한 선수의 이름만 출력하세요
		list.stream()
			.filter( (vo) -> vo.getYear().startsWith("195"))
			.map( (vo) -> vo.getPlayerID())
			.forEach(System.out::println);
		
		System.out.println("======================");
		
		//4. 2000년대 BOS 팀의 선수 이름을 중복 제거한 후 출력하세요.
		//List<String> bosList = 
				list.stream()
					.filter( (vo) -> vo.getYear().startsWith("200"))
					.filter( (vo) -> vo.getTeamID().equals("BOS"))
					.map( (vo) -> vo.getPlayerID())
					.distinct()
					.forEach(System.out::println);
				
		System.out.println("=====================");
		
		//5. 1937년 DET 팀의 선수 중 첫 번째 선수 이름을 출력
			AllStarFullVO detPlayer = list.stream()
										  .filter( (vo) -> vo.getYear().equals("1937"))
										  .filter( (vo) -> vo.getTeamID().equals("DET"))
										  .findFirst()
										  .orElse(new AllStarFullVO());
			System.out.println(detPlayer.getPlayerID());
	}
	

}
