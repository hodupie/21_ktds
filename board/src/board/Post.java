package board;


/**
 * 게시글 데이터 객체
 * @author User
 *
 */
public class Post {
	
	/**
	 * 제목
	 */
	private String title;
	
	/**
	 * 작성자
	 */
	private String writer;
	
	/**
	 * 글 번호
	 */
	private int number;
	
	/**
	 * 조회수
	 */
	private int view;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	
	@Override
	public String toString() {
		return "제목: " + title + "\n" + "작성자: " + writer + "\n" + "글 번호: " + number + "\n" + "조회수: " + view;
	}
	

	
	

}
