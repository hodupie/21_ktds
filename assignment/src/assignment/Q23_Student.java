package assignment;

import java.util.ArrayList;
import java.util.List;

public class Q23_Student {
	private String name;
	private static List<String> gradeList;
	
	public Q23_Student () {
		gradeList = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static List<String> getGradeList() {
		return gradeList;
	}

	public static void setGradeList(List<String> gradeList) {
		Q23_Student.gradeList = gradeList;
	}
	

}
