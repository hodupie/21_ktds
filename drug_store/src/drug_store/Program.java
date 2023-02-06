package drug_store;

public class Program {
	
	DrugStore drugStore = new DrugStore();
	
	public static void main(String[] args) {
		
		Program program = new Program();
		program.drugStore.visit();
		program.drugStore.perscribe();
		
		
	}

}
