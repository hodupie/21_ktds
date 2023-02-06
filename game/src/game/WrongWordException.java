package game;

/**
 * 잘못된 단어를 입력한 경우 혹은 "포기"를 입력한 경우 던질 예외
 * @author User
 *
 */
public class WrongWordException extends RuntimeException {

	private static final long serialVersionUID = -3668209091174349187L;
	
	public WrongWordException() {
		super();
	}

}
