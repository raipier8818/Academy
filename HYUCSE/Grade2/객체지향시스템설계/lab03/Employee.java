package prac3;

public class Employee {
	private String name;
	private int age;
	private String position;
	private int salary;
	private int vacationDays;

	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
		this.position = "Employee";
		this.salary = 5000;
		this.vacationDays = 20;
	}
	public Employee(String name, int age, String position, int salary) {
		this.name = name;
		this.age = age;
		this.position = position;
		this.salary = salary;
		this.vacationDays = 20;
	}
	public Employee(String name, int age, String position, int salary, int vacationDays) {
		this.name = name;
		this.age = age;
		this.position = position;
		this.salary = salary;
		this.vacationDays = vacationDays;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getVacationDays() {
		return vacationDays;
	}
	public void setVacationDays(int vacationDays) {
		this.vacationDays = vacationDays;
	}
	
	public boolean equals(Employee other) {
		if(other.getName() == this.getName() && other.getAge() == this.getAge() && other.getPosition() == this.getPosition()) {
			return true;
		}else {
			return false;
		}
	}
	
	public String toString() {
		String employeeInfo = "";
		employeeInfo += "Name : " + this.getName();
		employeeInfo += ", Age : " + this.getAge();
		employeeInfo += ", Position : " + this.getPosition();
		employeeInfo += ", Salary : " + this.getSalary();
		employeeInfo += ", VacationDay : " + this.getVacationDays();
		
		return employeeInfo;
	}
	
	public void Vacation(int vacation) {
		if(this.vacationDays < vacation) {
			System.out.println("���� �ް� �ϼ��� �����մϴ�.");
			return;
		}else {
			this.vacationDays -= vacation;
			System.out.println("�ް��� ����Ͽ����ϴ�. ���� �ް��ϼ� : " + this.getVacationDays());
			return;
		}
	}
}
