package prac1;
import java.util.Scanner;

public class prac1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(", ");
		String[] name = input[0].split(" ");

		for(int i = 0; i < 3; i++) {
			name[i] = name[i].substring(0,1).toUpperCase() + name[i].substring(1);
		}
		
		input[1] = input[1].substring(0,1).toUpperCase() + input[1].substring(1);		
		input[1] = input[1].replace("ppt", "pdf");
		
		String printString = name[1].charAt(0) + "." + name[2].charAt(0) + "." + name[0];
		
		
		System.out.println("Name Length(Korean) : " + name.length);
		System.out.println(printString + " submitted " + input[1]);
		
		
	}
}
