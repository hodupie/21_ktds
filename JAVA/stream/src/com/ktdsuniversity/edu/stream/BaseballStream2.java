package com.ktdsuniversity.edu.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseballStream2 {

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
		
		System.out.println("=================1===================");
		// 1. 1933년 NYA팀의 세 번째 선수의 playerID를 출력
		Optional<String> playerID = list.stream()
										.filter( (vo) -> vo.getYear().equals("1933"))
										.filter( (vo) -> vo.getTeamID().equals("NYA"))
										.map( (vo) -> vo.getPlayerID())
										.peek(System.out::println)
										.skip(2)
										.limit(1)
										.findFirst();
		
		System.out.println(playerID.orElse("없음"));
		
		System.out.println("==================2===================");
		
		// 2. 1700년 NYA팀의 세 번째 선수의 playerID를 출력
		
		// list.stream()을 Stream<AllStarFullVO>의 형태로 변환
		Stream <AllStarFullVO> listStream = list.stream();
		// listStream으로 데이터 filtering
		// AllStarFullVO의 인스턴스가 vo에 전달됨
		Stream <AllStarFullVO> playersIn1700 = listStream.filter( (vo) -> vo.getYear().equals("1700"));
		// playersIn1700 filtering
		// playersIn1700의 타입인 AllStarFull의 인스턴스가 vo에 전달됨
		Stream <AllStarFullVO> playersInNYA = playersIn1700.filter( (vo) -> vo.getTeamID().equals("NYA"));
		// playersInNYA의 타입인 AllStarFullVㅒ의 인스턴스가 vo에 전달됨
		// AllStarFullVO의 playerID만 get
		// map을 통해 playerID만 남김 (playerID의 타입인 String으로 타입 변경됨)
		Stream <String> playersId = playersInNYA.map( (vo) -> vo.getPlayerID());
		// 두 개 건너뛰기
		Stream <String> skipedPlayersId = playersId.skip(2);
		// 앞 하나만 가져오기
		Stream <String> limitedPlayersID = skipedPlayersId.limit(1);
		// 데이터 없음 -> playerId = null (playerId는 String 타입 but 데이터가 null)
		Optional <String> playerId = limitedPlayersID.findFirst();
		// playerId가 null이므로 "없음" 출력
		System.out.println(playerId.orElse("없음"));
		
		System.out.println("=================3====================");
		// 3. 1934년 CHA 팀에서 startingPos가 8인 선수의 playerID 출력
		
		Optional<String> CHAPlayer = list.stream()
										 .filter( (vo) -> vo.getYear().equals("1934"))
										 .filter( (vo) -> vo.getTeamID().equals("CHA"))
										 .filter( (vo) -> vo.getStartingPos() == 8)
										 .map( (vo) -> vo.getPlayerID())
										 .findFirst();
		System.out.println(CHAPlayer.orElse("없음"));
			
		
		System.out.println("=================4====================");
		// 4. 1934년 CHA 팀에서 startingPos가 8인 두 번째 선수의 playerID 출력
		
		Optional<String> CHASecondPlayer = list.stream()
								 				.filter( (vo) -> vo.getYear().equals("1934"))
												 .filter( (vo) -> vo.getTeamID().equals("CHA"))
												 .filter( (vo) -> vo.getStartingPos() == 8)
												 .map( (vo) -> vo.getPlayerID())
												 .skip(1)
												 .findFirst();
		System.out.println(CHASecondPlayer.orElse("없음"));
		
		System.out.println("======================================");
		
		// 5-1. 1933년에 출전한 TeamID별 playerId를 모두 출력 (group)
		Map<String, List<AllStarFullVO>> teamMap1 = list.stream()
														.filter( (vo) -> vo.getYear().equals("1933"))
														//List가 가지고 있는 값을 getTeamID로 그룹화하기		
//														.collect(Collectors.groupingBy(vo -> vo.getTemaID()))
														.collect(Collectors.groupingBy(AllStarFullVO::getTeamID));
		
		System.out.println("===========forEach 1==========");
		teamMap1.forEach((teamId, players) -> {
			players.stream()
				   .map(vo -> vo.getPlayerID())
				   .forEach((playerId2) -> {
						System.out.println(teamId + ":" + playerId2);
					});
		});
			
		
		System.out.println("===========forEach 2==========");
		teamMap1.forEach((key,value) -> {
			for(AllStarFullVO allStarFullVO : value) {
				System.out.println(key + ":" + allStarFullVO.getPlayerID());
			}
		});

		System.out.println("============5-2==============");
		// 5-2. 1933년에 출전한 TeamID별 playerId의 수를 모두 출력 (group)
		Map<String, List<AllStarFullVO>> teamMap2 = list.stream()
														.filter( (vo) -> vo.getYear().equals("1933"))
														.collect(Collectors.groupingBy(AllStarFullVO::getTeamID));
		
		teamMap2.forEach((key, value) -> {
			System.out.println(key + ":" + value.size());
		});
		System.out.println("===========6=============");
		// 6. TeamID 별 출전 연도를 모두 출력 (group)
			Map<String, List<AllStarFullVO>> teamYear = list.stream()
															.collect(Collectors.groupingBy(AllStarFullVO::getTeamID));
			
//			System.out.println(teamYear);
			teamYear.forEach((teamId, year) -> {
				year.stream()
					.map(vo -> vo.getYear())
					.forEach((year2) -> {
						System.out.println(teamId + " > " + year2);
					});
			});
			
		System.out.println("================7============");
		// 7. TeamID 별 출전 연도를 중복제거하여 모두 출력 (group)
			Map<String, List<AllStarFullVO>> teamYear2 = list.stream()
															 .collect(Collectors.groupingBy(AllStarFullVO::getTeamID));
			
			teamYear2.forEach((teamId, year) -> {
				 year.stream()
				 	 .map(vo -> vo.getYear())
				 	 .distinct()
					 .forEach((year2) -> {
						 System.out.println(teamId + " > " + year2);
					});
			});
			
		
		// 8-1. 10K.ID.CONTENTS 파일에서 "12370584"의 내용을 출력
			
		
		// 8-2. (병렬) 10K.ID.CONTENTS 파일에서 "12370584"의 내용을 출력
		
		
		
	
	}

}
