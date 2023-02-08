package assignment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q23_Student {
	private String name;
	private static Map<String, Integer> gradeList;
	
	public Q23_Student () {
		gradeList = new HashMap<>();
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
