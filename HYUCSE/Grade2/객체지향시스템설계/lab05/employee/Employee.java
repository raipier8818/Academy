package kr.co.lab05.employee;

public class Employee {
	private String name;
	private double yearlySalary;
	private double monthlySalary;
	private double balance;
	
	public Employee(String name, double yearlySalary) {
		this.name = name;
		this.yearlySalary = yearlySalary;
		this.monthlySalary = yearlySalary/12;
		this.balance = 0;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void increaseYearlySalary(int byPercent) {
		this.yearlySalary = (this.yearlySalary / 100) * (byPercent + 100);
		this.monthlySalary = this.yearlySalary/12;
	}
	
	public void receiveSalary() {
		this.balance += this.monthlySalary;
	}
	
	public String toString() {
		return "�̸� : " + this.name + " ���� : " + this.yearlySalary + " ���� : " + this.monthlySalary + " ��� : " + this.balance; 
	}

}
