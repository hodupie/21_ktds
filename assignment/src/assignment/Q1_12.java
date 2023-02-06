package assignment;

public class Q1_12 {
	
	public static int question9(int num) {
		return num*num;
	}
	
	public static double question10(int num) {
		return (double) num;
	}
	
	public static int question11(int num, double num2) {
		return num * (int) num2;
	}
	
	public static void question12(int num, int num2, int num3) {
		System.out.println(num * num2 * num3);
	}
	
	
	public static void main(String[] args) {
		System.out.println("=====문제1=====");
		int a = 1;
		int b = 2;
		
		System.out.println("=====문제2=====");
		int n1 = 10;
		int n2 = 49;
		int n3 = 87;
		int n4 = 176;
		int sum = n1 + n2 + n3 + n4;
		System.out.println("sum");
		
		System.out.println("=====문제3=====");
		int multi = n4 * n2;
		System.out.println(multi);

		System.out.println("=====문제4=====");
		int quotient = n4/n2;
		System.out.println(quotient);
		
		System.out.println("=====문제5=====");
		int reminder = n4%n2;
		System.out.println(reminder);
		
		System.out.println("=====문제6=====");
		double quotient2 = (double) n4/n2;
		System.out.println(quotient2);
		
		System.out.println("=====문제7=====");
		double quotient3 = (double) n4/n2;
		System.out.println(String.format("%.2f", quotient3));
		
		System.out.println("=====문제8=====");
		long n5 = 1898277829827137627L;
		int n6 = (int) n5;
		System.out.println(n6);
		
		System.out.println("=====문제9=====");
		int question9 = question9(19);
		System.out.println(question9);
		
		System.out.println("=====문제10=====");
		double question10 = question10(938);
		System.out.println(question10);
		
		System.out.println("=====문제11=====");
		int question11 = question11(14, 198.2);
		System.out.println(question11);
		
		System.out.println("=====문제12=====");
		question12(14, 195, 76);

		
		
	}
	
	

}
