package board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 게시판 기능 서비스
 * 
 * @author User
 *
 */
public class PostList {

	/**
	 * 게시글 목록
	 */
	private List<Post> postList = new ArrayList<>();

	/**
	 * 게시글 등록 순번은 boardList의 size로 생성 조회수는 0으로 초기화
	 * 
	 * @param title  제목
	 * @param writer 작성자
	 */
	public void create(String title, String writer) {
		Post post = new Post();
		post.setTitle(title);
		post.setWriter(writer);
		post.setNumber(postList.size());
		post.setView(0);
		postList.add(post);
	}

	/**
	 * 게시글 수정 제목만 수정할 수 있다.
	 * 
	 * @param index 게시글의 인덱스
	 * @param title 제목
	 */
	public void update(int index, String title) {
		Post post = postList.get(index);
		post.setTitle(title);
	}

	/**
	 * 게시글 삭제 한 건의 게시글만 삭제할 수 있다.
	 * 
	 * @param index 삭제하려는 게시글의 인덱스
	 */
	public void delete(int index) {
		postList.remove(index);
	}

	/**
	 * 게시글 조회
	 * 
	 * @param index 조회하려는 게시글의 인덱스
	 */
	public void read(int index) {
		
		//조회하려는 번호의 게시물이 있는지
		if (postList.size() <= index) {
			System.out.println(index + "번 게시글은 존재하지 않습니다.");
			return; 	//read 메소드 종료
		}
		
		Post post = postList.get(index);

//		게시글을 조회하면 조회수가 1 증가한다. --> 출력 전 증가시킨 후 read
//		int readCount = post.getView();
//		readCount++;
//		post.setView(readCount);
		post.setView(post.getView() + 1);
		
		System.out.println("제목: " + post.getTitle());
		System.out.println("작성자: " + post.getWriter());
		System.out.println("글 번호: " + post.getNumber());
		System.out.println("조회수: " + post.getView());
		System.out.println("");

	}
	
	// 전체보기기능(for)
	public void readAll() {
		for (int i = 0; i < postList.size(); i += 1) {
			Post post = postList.get(i);
			post.setView(post.getView() + 1);
//			System.out.println("제목: " + post.getTitle());
//			System.out.println("작성자: " + post.getWriter());
//			System.out.println("글 번호: " + post.getNumber());
//			System.out.println("조회수: " + post.getView());
			System.out.println(post);
			System.out.println("");
		}
	}

	public void readAllWithoutIndex() {
		for (Post post: postList) {
			post.setView(post.getView() + 1);
//			System.out.println("제목: " + post.getTitle());
//			System.out.println("작성자: " + post.getWriter());
//			System.out.println("글 번호: " + post.getNumber());
//			System.out.println("조회수: " + post.getView());
			System.out.println(post);
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		PostList post = new PostList();

		post.create("제목1", "호두");
		post.create("제목2", "땅콩");
		post.create("제목3", "캐슈넛");

//		post.read(0);
//		post.read(1);
//		post.read(2);
//
//		post.read(1);
//		post.read(2);
//		post.read(0);
//		post.read(1);
//		
//		post.update(1, "제목 2-1");
//		post.read(1);
//		
//		post.delete(0);
//		
//		post.read(2);
		
//		post.readAll();
//		
//		System.out.println("=========");
//		
//		post.readAllWithoutIndex();
		
		//무한반복
		Scanner scan = new Scanner(System.in);
		
		while (true) {			
			System.out.println("메뉴를 입력하세요.");
			System.out.println("1. 등록");
			System.out.println("2. 수정");
			System.out.println("3. 삭제");
			System.out.println("4. 조회");
			System.out.println("5. 종료");
			
			int menu = scan.nextInt();
			scan.nextLine();
			
			if (menu == 1) {
				//등록
				System.out.println("제목을 입력하세요. ");
				String title = scan.nextLine();
				
				System.out.println("작성자를 입력하세요. ");
				String writer = scan.nextLine();
				
				post.create(title, writer);
				System.out.println("게시글이 등록되었습니다.");
			}
			else if (menu == 2) {
				//수정
				
			}
			else if (menu == 3) {
				//삭제
				System.out.println("삭제할 게시물의 인덱스를 입력하세요. ");
				int index = scan.nextInt();
				post.delete(index);
			}
			else if (menu == 4) {
				//조회
				post.readAll();
				System.out.println("모든 게시글을 조회했습니다.");
			}
			else {
				//종료
				System.out.println("종료합니다.");
				break;
			}
			
		}
		


	}
}
