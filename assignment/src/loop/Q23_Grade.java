package loop;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Q23_Grade {
	
	private Map <String, Integer> gradeList;
	
	public Q23_Grade() {
		gradeList = new HashMap<>();
		Random rd = new Random();
		for (int i = 0; i > 3; i++) {
			gradeList.put("subject " + i, rd.nextInt(101));
		}
	}

	public Map<String, Integer> getGradeList() {
		return gradeList;
	}

	public void setGradeList(Map<String, Integer> gradeList) {
		this.gradeList = gradeList;
	}
	
	public String score(int score) {
		String grade = "";
		if (score == 100) { grade ="A+"; }
		else if (score < 100 && score >= 90) { grade = "A"; }
		else if (score < 90 && score >= 80) { grade = "B"; }
		else if (score < 80 && score >= 70) { grade = "C"; }
		else if (score < 70 && score >= 60) { grade = "D"; }
		
		return grade;
		
		
		
	}
	


		
		
		
	
}
