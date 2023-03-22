package com.ktdsuniversity.edu.goodgag;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ktdsuniversity.edu.goodgag.member.dao.MemberDAO;
import com.ktdsuniversity.edu.goodgag.member.dao.MemberDAOImpl;
import com.ktdsuniversity.edu.goodgag.member.vo.MemberVO;

public class GoodGagDAO {
	
	// DB 정보 읽어오기
	public static void printAllMembers() {
		// 1. Oracle Driver Loading
		// oracle.jdbc.driver.OracleDriver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		
		// 2. Oracle DB에 연결
		// jdbc:oracle:thin:@localhost:1521:XE
		
		//Java와 DB를 연결하는 객체
		Connection conn = null;
		// DB에게 쿼리를 실행요청하는 객체
		PreparedStatement pstmt = null;
		// 쿼리의 실행 결과를 받아오는 객체
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BBS", "BBS1234");
			
		// 3. Query 작성
		// StringBuffer: 여러 줄의 String을 작성할 때 사용할 수 있는 객체
		// 쿼리 작성 시 앞뒤로 한 칸씩 띄워주어야 한다.
			StringBuffer query = new StringBuffer();
			query.append(" SELECT EMAIL "); 
			query.append(" 	    , VERIFIED_YN "); 
			query.append("      , PASSWORD "); 
			query.append(" 	    , NICKNAME "); 
			query.append("      , TO_CHAR(JOIN_DATE, 'YYYY-MM-DD HH24:MI:SS') JOIN_DATE ");
			query.append("   FROM MEMBER "); 
			
		// 3-1. Query 실행하기
			pstmt = conn.prepareStatement(query.toString());
			rs = pstmt.executeQuery();
			
		// 4. Query 결과 받아오기
		// ResultSet
		// 날짜 타입도 TO_CHAR로 String으로 받아온다.
		// rs.next(): Cursor를 한 칸 아래로 내린다
			while (rs.next()) {
				//rs.get~("컬럼명"): Cursor가 가리키는 ROW의 COLUMN 데이터를 받아온다
				String email = rs.getString("EMAIL");
				String verifiedYn = rs.getString("VERIFIED_YN");
				String password = rs.getString("PASSWORD");
				String nickname = rs.getString("NICKNAME");
				String joinDate = rs.getString("JOIN_DATE");
				
				System.out.println(email + "\t" + verifiedYn + "\t" + password + "\t" + nickname + "\t" + joinDate + "\t");
			}
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		// 5. DB 연결 해제
		// 쿼리 성공 실패 여부와 상관없이 무조건 연결 해제
		finally {
			// DB연결 실패 시 NullPointerException 회피
			if (rs != null) {
				try {
					rs.close();
				}
				catch(SQLException sqle) {}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				}
				catch(SQLException sqle) {}
			}
			
			if (conn != null) {
				try {
					conn.close();
				}
				catch(SQLException sqle) {}
			}	
		}
	}
	
	public static void printAllArticles() {

		// 1. Oracle Driver Loading
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		
		// 2. Database 연결
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BBS", "BBS1234");
		
		// 3. Query 작성
			StringBuffer query = new StringBuffer();
		
			query.append(" SELECT ARTICLE_NO                                                ");
			query.append("  	, EMAIL                                                     ");
			query.append(" 	    , TO_CHAR(REGIST_DATE, 'YYYY-MM-DD HH24:MI:SS') REGIST_DATE ");
			query.append(" 	 	, TITLE                                                     ");
			query.append(" 		, DESCRIPT                                                  ");
			query.append(" 	 	, SOURCE                                                    ");
			query.append(" 	 	, NOTI_YN                                                   ");
			query.append("   FROM ARTICLE                                                   ");
		
		// 4. Query 실행                                                             
			pstmt = conn.prepareStatement(query.toString());
			rs = pstmt.executeQuery();
			
		// 5. Query 결과 받아서 출력
			while (rs.next()) {
				String articleNo = rs.getString("ARTICLE_NO");
				String email = rs.getString("EMAIL");
				String registDate = rs.getString("REGIST_DATE");
				String title = rs.getString("TITLE");
				String descript = rs.getString("DESCRIPT");
				String source = rs.getString("SOURCE");
				String notiYn = rs.getString("NOTI_YN");
				
				System.out.println(articleNo + "\t" + email + "\t" + registDate + "\t" + title + "\t" + descript + "\t" + source + "\t" + notiYn);
			}
		
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		// 6. DB 연결 해제
		finally {
			if (rs != null) {
				try {
					rs.close();
				}
				catch (SQLException sqle) {}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				}
				catch (SQLException sqle) {}
			}
			
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException sqle) {}
			}
		}
	}
	
	public static void printAllReplies() {
		// 1. Oracle Driver Loading
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		
		// 2. Database 연결
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BBS", "BBS1234");
		
		// 3. Query 작성
			StringBuffer query = new StringBuffer();
		
			query.append(" SELECT REPLY_NO                                                  ");
			query.append("  	, ARTICLE_NO                                                ");     
			query.append("  	, EMAIL                                                     ");
			query.append(" 	    , TO_CHAR(REGIST_DATE, 'YYYY-MM-DD HH24:MI:SS') REGIST_DATE ");
			query.append(" 	    , TO_CHAR(MODIFY_DATE, 'YYYY-MM-DD HH24:MI:SS') MODIFY_DATE ");
			query.append(" 	 	, REPLY                                                     ");
			query.append(" 		, PARENT_REPLY_NO                                           ");
			query.append("   FROM REPLIES                                                   ");
		
		// 4. Query 실행                                                             
			pstmt = conn.prepareStatement(query.toString());
			rs = pstmt.executeQuery();
			
		// 5. Query 결과 받아서 출력
			while (rs.next()) {
				String replyNo = rs.getString("REPLY_NO");
				String articleNo = rs.getString("ARTICLE_NO");
				String email = rs.getString("EMAIL");
				String registDate = rs.getString("REGIST_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String reply = rs.getString("REPLY");
				String parentReplyNo = rs.getString("PARENT_REPLY_NO");
				
				System.out.println(replyNo + "\t" + articleNo + "\t" + email + "\t" + registDate + "\t" + modifyDate + "\t" + reply + "\t" + parentReplyNo);
			}
		
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		// 6. DB 연결 해제
		finally {
			if (rs != null) {
				try {
					rs.close();
				}
				catch (SQLException sqle) {}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				}
				catch (SQLException sqle) {}
			}
			
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException sqle) {}
			}
		}
	}
	
	// 회원 한 명만 조회
	// DB에게 parameter를 주는 법
	public static void printOneMembers(String pEmail, String pPassword) {
		// 1. Oracle Driver Loading
		// oracle.jdbc.driver.OracleDriver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		
		// 2. Oracle DB에 연결
		// jdbc:oracle:thin:@localhost:1521:XE
		
		//Java와 DB를 연결하는 객체
		Connection conn = null;
		// DB에게 쿼리를 실행요청하는 객체
		PreparedStatement pstmt = null;
		// 쿼리의 실행 결과를 받아오는 객체
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BBS", "BBS1234");
			
		// 3. Query 작성
		// StringBuffer: 여러 줄의 String을 작성할 때 사용할 수 있는 객체
		// 쿼리 작성 시 앞뒤로 한 칸씩 띄워주어야 한다.
			StringBuffer query = new StringBuffer();
			query.append(" SELECT EMAIL "); 
			query.append(" 	    , VERIFIED_YN "); 
			query.append("      , PASSWORD "); 
			query.append(" 	    , NICKNAME "); 
			query.append("      , TO_CHAR(JOIN_DATE, 'YYYY-MM-DD HH24:MI:SS') JOIN_DATE ");
			query.append("   FROM MEMBER ");
		// WHERE절 추가
			query.append("  WHERE EMAIL = ?");
			query.append("    AND PASSWORD = ?");
			
		// 3-1. Query 실행하기
			pstmt = conn.prepareStatement(query.toString());
			
		// 3-2. 쿼리 파리미터 바인딩하기 (WHERE절의 ?에 들어갈 내용) -> index는 1부터 시작
			pstmt.setString(1, pEmail);
			pstmt.setString(2, pPassword);
			
			rs = pstmt.executeQuery();
			
		// 4. Query 결과 받아오기
		// ResultSet
		// 날짜 타입도 TO_CHAR로 String으로 받아온다.
		// rs.next(): Cursor를 한 칸 아래로 내린다
			while (rs.next()) {
				//rs.get~("컬럼명"): Cursor가 가리키는 ROW의 COLUMN 데이터를 받아온다
				String email = rs.getString("EMAIL");
				String verifiedYn = rs.getString("VERIFIED_YN");
				String password = rs.getString("PASSWORD");
				String nickname = rs.getString("NICKNAME");
				String joinDate = rs.getString("JOIN_DATE");
				
				System.out.println(email + "\t" + verifiedYn + "\t" + password + "\t" + nickname + "\t" + joinDate + "\t");
			}
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		// 5. DB 연결 해제
		// 쿼리 성공 실패 여부와 상관없이 무조건 연결 해제
		finally {
			// DB연결 실패 시 NullPointerException 회피
			if (rs != null) {
				try {
					rs.close();
				}
				catch(SQLException sqle) {}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				}
				catch(SQLException sqle) {}
			}
			
			if (conn != null) {
				try {
					conn.close();
				}
				catch(SQLException sqle) {}
			}	
		}
	}
	
	public static void main(String[] args) {

		// utils 사용 X
//		printAllMembers();
//		System.out.println("=====================================================================");
//		printAllArticles();
//		System.out.println("=====================================================================");
//		printAllReplies();
//		System.out.println("=====================================================================");
//		printOneMembers("funnydog@gmail.com", "funny1234");
		
		// utils 사용 O
		MemberDAO memberDAO = new MemberDAOImpl();
		List<MemberVO> allMemberList = memberDAO.getAllMembers();
		MemberVO member = memberDAO.getOneMember("funnydog@gmail.com", "funny1234");
		
		for (MemberVO eachMember: allMemberList) {
			System.out.println(eachMember.getEmail());
			System.out.println(eachMember.getVerifiedYn());
			System.out.println(eachMember.getPassword());
			System.out.println(eachMember.getNickname());
			System.out.println(eachMember.getJoinDate());
			System.out.println("===================================");
		}
		
	}
}
