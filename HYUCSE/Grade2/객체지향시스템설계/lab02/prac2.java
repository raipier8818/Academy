package prac2;
import java.util.Scanner;


public class prac2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] grades = scan.nextLine().toUpperCase().split(" ");
		int[] scores = new int[grades.length];
		
		double ave = 0;
		
		for(int i = 0; i < grades.length; i++) {
			switch (grades[i]) {
			case "A":
				scores[i] = 100;
				ave += 100;
				break;
			case "B":
				scores[i] = 90;
				ave += 90;
				
				break;
			case "C":
				scores[i] = 80;
				ave += 80;
				
				break;
			case "D":
				scores[i] = 70;
				ave += 70;
				
				break;
			case "F":
				scores[i] = 0;
				ave += 0;
					
				break;
			}
			
		}
		for(int i = 0; i < scores.length; i++) {
			if(i == 0) {
				System.out.println("1st student's score is " + scores[i]);
			}
			else if(i == 1) {
				System.out.println("2nd student's score is " + scores[i]);
			}
			else if(i == 2) {
				System.out.println("3rd student's score is " + scores[i]);
			}
			else {
				System.out.println(i+1 + "th student's score is " + scores[i]);
			}
		}
		//System.out.println(ave);
		System.out.println("This class's average = " + ave/scores.length);
	}
}
