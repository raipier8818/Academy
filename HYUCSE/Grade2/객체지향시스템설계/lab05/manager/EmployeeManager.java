package kr.co.lab05.manager;

import java.time.LocalDate;
import java.util.Random;

import kr.co.lab05.employee.*;

public class EmployeeManager {
	public static void main(String[] args) {
		Employee A = new Employee("Joo", 4500);
		LocalDate d = LocalDate.of(2021, 04, 01);
		LocalDate firstDate = LocalDate.of(2021, 04, 01);
		
		System.out.println("����� : " + d);
	
		System.out.println(A.toString());
		
		Random rand = new Random();
		
		int randomMonth = rand.nextInt(12) + 1;
		
		
		while(A.getBalance() < 20000) {
			if(d.getYear() != firstDate.getYear() && d.getMonthValue() == firstDate.getMonthValue()) {
				int randomInc = rand.nextInt(11);
				A.increaseYearlySalary(randomInc);
				System.out.println(d.getYear() - firstDate.getYear() + 1 + "���� ������ " + randomInc + "% �λ�Ǿ����ϴ�.");
				randomMonth = rand.nextInt(12) + 1;
			}
			
			
			if(randomMonth == d.getMonthValue()) {
				A.receiveSalary();
				A.receiveSalary();
				System.out.println(d.getYear() - firstDate.getYear() + 1 + "���� " + d.getMonthValue() + "���� �μ�Ƽ�긦 �޾ҽ��ϴ�.");
			}
			else {
				A.receiveSalary();
			}
			
			if(d.getMonthValue() == 12) {
				d = LocalDate.of(d.getYear() + 1, 1, d.getDayOfMonth());
			}else {
				d = LocalDate.of(d.getYear(), d.getMonthValue() + 1, d.getDayOfMonth());
			}
			
			
		}
		
		System.out.println("��¥ : " + d);
		System.out.println(A.toString());
		
		
	}
}
