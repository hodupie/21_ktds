package com.ktdsuniversity.edu.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BaseballStream1 {

	public static List<AllStarFullVO> readAllStarFull() {

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

		
		list.stream() // list -> stream
				.filter((vo) -> vo.getYear().equals("1933"))
				.forEach((vo) -> {
					System.out.println(vo.getPlayerID());
					System.out.println(vo.getYear());
				});

		List<AllStarFullVO> playIn1933 = list.stream()
											.filter((vo) -> vo.getYear().equals("1933"))
											.collect(Collectors.toList());
		
		AllStarFullVO voItem = list.stream()
								.filter( (vo1) -> vo1.getYear().equals("2022"))
								.findFirst()					// 최종함수. optional: 데이터가 있으면 첫번째 값 return
//																// null값이면 orElse값 return 
////								.get();
								.orElse(new AllStarFullVO());
		System.out.println(voItem.getPlayerID());
		
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
//	
//		list.stream()
//			.filter( (allStarVO) -> allStarVO.getStartingPos() == 0)
//			.forEach( (allStarVO) -> {
//				System.out.println(allStarVO.getPlayerID());
//				System.out.println(allStarVO.getStartingPos());
//			});
		
		
		System.out.println("=================");
		//gp == 0, teamID == NYA, PlayerID include "fo" 
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
		
		System.out.println("=================");
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
		System.out.println("=================");
		
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
		list.stream()
			.filter( (allStarVO) -> allStarVO.getGameNum() != 0)
			.forEach( (allStarVO) -> {
				System.out.println(allStarVO.getPlayerID());
				System.out.println(allStarVO.getGameNum());
			});
		
		System.out.println("=======1-2======");
		
		List<String> Q1List = list.stream()
									.filter( (vo) -> vo.getGameNum() != 0)
									.map( (vo) -> vo.getPlayerID())
									.collect(Collectors.toList());
		Q1List.forEach(System.out::println);
		
		//2. gameNum이 0인것 추출해 출력
		System.out.println("========2=====");
		list.stream()
			.filter( (vo) -> vo.getGameNum() == 0)
			.forEach( (vo) -> {
				System.out.println(vo.getPlayerID());
				System.out.println(vo.getGameNum());
			});
		
		System.out.println("=========2-2=========");
		
		List<AllStarFullVO> gameNum = list.stream()
											.filter( (vo) -> vo.getGameNum() == 0)
											.collect(Collectors.toList());
		gameNum.forEach((vo) -> {
			System.out.println(vo.getPlayerID());
			System.out.println(vo.getGameNum());
		});
		
		System.out.println("========3===========");
		//3. 1950년대에 플레이한 선수의 이름만 출력하세요
		list.stream()
			.filter( (vo) -> vo.getYear().startsWith("195"))
			.map( (vo) -> vo.getPlayerID())
			.forEach(System.out::println);
		
		System.out.println("===========4===========");
		
		//4. 2000년대 BOS 팀의 선수 이름을 중복 제거한 후 출력하세요.
		//List<String> bosList = 
				list.stream()
					.filter( (vo) -> vo.getYear().startsWith("200"))
					.filter( (vo) -> vo.getTeamID().equals("BOS"))
					.map( (vo) -> vo.getPlayerID())
					.distinct()
					.forEach(System.out::println);
				
		System.out.println("==========5===========");
		
		//5. 1937년 DET 팀의 선수 중 첫 번째 선수 이름을 출력
			AllStarFullVO detPlayer = list.stream()
										  .filter( (vo) -> vo.getYear().equals("1937"))
										  .filter( (vo) -> vo.getTeamID().equals("DET"))
										  .findFirst()
										  .orElse(new AllStarFullVO());
			System.out.println(detPlayer.getPlayerID());
		
		System.out.println("============6===========");
		// 6. gp = 0, startingPos = 3인 선수 이름 출력
			list.stream()
				.filter( (vo) -> vo.getGp() == 0)
				.filter( (vo) -> vo.getStartingPos() == 3)
				.forEach( (vo) -> {
					System.out.println(vo.getPlayerID());
				});
			
		
		System.out.println("========7==========");	
		// 7. BOS 팀에 있는 선수는 총 몇명인가요?
		long BOSteam = list.stream()
						   .filter(vo -> vo.getTeamID().equals("BOS"))
						   .count();
		System.out.println(BOSteam);
		
		
		System.out.println("=============8===========");
		
		//8. 이름이 foxx로 시작하는 선수의 플레이 연도를 중복제거 후 출력
		list.stream()
			.filter(vo -> vo.getPlayerID().startsWith("foxx"))
			.map(vo -> vo.getYear())
			.distinct()
			.forEach(System.out::println);
		
		System.out.println("=============9===========");
		
		//9.lombaer01 선수는 몇년도에 어느 팀에서 플레이했나?
		list.stream()
			.filter(vo -> vo.getPlayerID().equals("lombaer01"))
			.forEach( vo -> {
				System.out.println(vo.getTeamID());
				System.out.println(vo.getYear());
			});
		
		System.out.println("=============9-2===========");
		
		list.stream()
			.filter(vo -> vo.getPlayerID().equals("lombaer01"))
			.map(vo -> vo.getYear() + " > " + vo.getTeamID())
			.forEach(System.out::println);
		
		System.out.println("=============10===========");
		// 10. muncyma01 선수의 year, startingPos와 teamID를 출력하세요
		list.stream()
			.filter(vo -> vo.getPlayerID().equals("muncyma01"))
			.forEach( vo -> {
				System.out.println(vo.getYear());
				System.out.println(vo.getStartingPos());
			});
		
		System.out.println("=============11===========");
		//11.2015년에 hernafe02 선수는 몇 번 출전했나요?
		long count = list.stream()
						 .filter(vo -> vo.getPlayerID().equals("hernafe02"))
						 .filter(vo -> vo.getYear().equals("2015"))
						 .count();
		System.out.println(count);
		
		System.out.println("=============12===========");
		//12. ATL팀이 몇 년도에 경기에 출전했나요?
		list.stream()
			.filter(vo -> vo.getTeamID().equals("ATL"))
			.map(vo -> vo.getYear())
			.distinct()
			.forEach(System.out::println);
		
		//13. W로 시작하는 팀은 몇 년도에 경기에 출전했나요?
		list.stream()
			.filter(vo -> vo.getTeamID().equals("W"))
			.map(vo -> vo.getYear())
			.distinct()
			.forEach(System.out::println);
		
		//14. GP와 startingPos가 모두 0인 선수 중 PHA팀에 소속했던 선수는 누구인가요?
		list.stream()
			.filter(vo -> vo.getGp() == 0)
			.filter(vo -> vo.getStartingPos() == 0)
			.filter(vo -> vo.getTeamID().equals("PHA"))
			.map(vo -> vo.getPlayerID())
			.forEach(System.out::println);
		
		//15. playerID의 자리수가 8자리인 선수의 활동연도를 중복제거하여 출력하세요
		list.stream()
			.filter(vo -> vo.getPlayerID().length() == 8)
			.map(vo -> vo.getYear())
			.distinct()
			.forEach(System.out::println);
		
		//16.playerID의 값이 02 또는 03으로 끝나는 선수의 팀코드를 중복제거하고 정렬하여 출력하세요.
		list.stream()
			.filter(vo -> vo.getPlayerID().endsWith("02") || vo.getPlayerID().endsWith("03"))
			.map(vo -> vo.getTeamID())
			.distinct()
			.sorted()
			.forEach(System.out::println);
		
		//17. lgID의 값이 AL, GameID는 60 으로 끝나며 소속팀은 DET, playerID는 f로 시작하는 첫번째 선수의 playerID를 출력하교 만약 존재하지 않는다면 "없음"출력
		Optional<String> ALplayer = list.stream()
										 .filter(vo -> vo.getLgID().equals("AL"))
										 .filter(vo -> vo.getGameID().endsWith("60"))
										 .filter(vo -> vo.getTeamID().equals("DET"))
										 .filter(vo -> vo.getPlayerID().toLowerCase().startsWith("f"))
										 .map(vo -> vo.getPlayerID())
										 .findFirst();
		System.out.println(ALplayer.orElse("없음"));
		
		
		
	}
			

}
