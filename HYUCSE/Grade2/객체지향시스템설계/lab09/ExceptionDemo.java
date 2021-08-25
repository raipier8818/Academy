package lab09;

import java.util.Scanner;

public class ExceptionDemo {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Employee A = new Employee("Joo");
		
		while(true) {
			try {
				System.out.printf("%d���� �ٹ� �ð��� �Է��ϼ��� : ", A.getWorkDay());
				int workHour = keyboard.nextInt();
				if (workHour < 0) throw new NegativeException();
				else if(workHour > 24) throw new TooMuchStuffException(workHour);
				else if(workHour == 0) throw new Exception("Program Exit");
				
				A.addWorkHours(workHour);
				A.addWorkDay();
				System.out.println("�̸� : " + A.getName());
				System.out.println("���� �ٹ� �ð� : " + A.getWorkHours());
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
