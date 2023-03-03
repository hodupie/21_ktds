package drug_store;

/**
 * 약국
 * @author User
 *
 */
public class DrugStore {
	
	/**
	 * 감기환자
	 */
	Customer cold = new Customer();
	
	/**
	 * 콧물환자
	 */
	Customer runnyNose = new Customer();
	
	/**
	 * 근육통 환자
	 */
	Customer musclePain = new Customer();
	
	/**
	 * 방문한다(이름과 증상을 알려준다)
	 */
	public void visit() {
		cold.name = "호두";
		cold.symptom = "감기";
		
		runnyNose.name = "땅콩";
		runnyNose.symptom = "콧물";
				
		musclePain.name = "캐슈넛";
		musclePain.symptom = "근육통";

	}
	
	/**
	 * 처방한다
	 */
	public void perscribe() {
		/*
		 * 감기환자: "이름"님, 감기증상이 있으시면 종합감기약 처방해 드립니다.
		 * 콧물환자: "이름"님, 콧물증상이 있으시면 코막힘약 처방해 드립니다.
		 * 근육통환자: "이름"님, 근육통증상이 있으시면 근육이완제 처방해 드립니다.
		 */
		
		String patientName = cold.name;
		String patientSymptom = cold.symptom;
		
		if (patientSymptom.equals("감기")) {
			System.out.println(patientName + "님, " + patientSymptom + "증상이 있으시면 종합감기약 처방해드립니다.");
		}
		else if (patientSymptom.equals("콧물")) {
			System.out.println(patientName + "님, " + patientSymptom + "증상이 있으시면 코막힘약 처방해드립니다.");
		}
		else {
			System.out.println(patientName + "님, " + patientSymptom + "증상이 있으시면 근육통 처방해드립니다.");
		}
		
		patientName = runnyNose.name;
		patientSymptom = runnyNose.symptom;
		
		if (patientSymptom.equals("감기")) {
			System.out.println(patientName + "님, " + patientSymptom + "증상이 있으시면 종합감기약 처방해드립니다.");
		}
		else if (patientSymptom.equals("콧물")) {
			System.out.println(patientName + "님, " + patientSymptom + "증상이 있으시면 코막힘약 처방해드립니다.");
		}
		else {
			System.out.println(patientName + "님, " + patientSymptom + "증상이 있으시면 근육통 처방해드립니다.");
		}
		
		patientName = musclePain.name;
		patientSymptom = musclePain.symptom;
		
		if (patientSymptom.equals("감기")) {
			System.out.println(patientName + "님, " + patientSymptom + "증상이 있으시면 종합감기약 처방해드립니다.");
		}
		else if (patientSymptom.equals("콧물")) {
			System.out.println(patientName + "님, " + patientSymptom + "증상이 있으시면 코막힘약 처방해드립니다.");
		}
		else {
			System.out.println(patientName + "님, " + patientSymptom + "증상이 있으시면 근육통 처방해드립니다.");
		}
		
	}

}
