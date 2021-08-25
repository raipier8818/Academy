package lab09;

import java.util.Scanner;

public class ExceptionDemo {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Employee A = new Employee("Joo");
		
		while(true) {
			try {
				System.out.printf("%d일차 근무 시간을 입력하세요 : ", A.getWorkDay());
				int workHour = keyboard.nextInt();
				if (workHour < 0) throw new NegativeException();
				else if(workHour > 24) throw new TooMuchStuffException(workHour);
				else if(workHour == 0) throw new Exception("Program Exit");
				
				A.addWorkHours(workHour);
				A.addWorkDay();
				System.out.println("이름 : " + A.getName());
				System.out.println("누적 근무 시간 : " + A.getWorkHours());
				System.out.println("No Exception has been occurred");
				
				
			} catch (NegativeException e) {
				System.out.println(e.getMessage());
			} catch (TooMuchStuffException e) {
				System.out.println(e.getInputNum() + ", " + e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(0);
			} finally {
				System.out.println("End of try-catch statement");
			}
		}
	}
}
