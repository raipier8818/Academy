package lab11;

public class Employee {
	private String name;
	private int employeeNum;
	private String department;
	private double salary;

	public Employee(String name, int employeeNum, String department, double salary) {
		this.name = name;
		this.employeeNum = employeeNum;
		this.department = department;
		this.salary = salary;
	}
	
	public Employee(Employee other) {
		this.name = other.name;
		this.employeeNum = other.employeeNum;
		this.department = other.department;
		this.salary = other.salary;
	}
	
	
	public String toString() {
		return "Name: " + name + "\nEmployee Number: " + employeeNum + "\nDepartment: " + department + "\nSalary: " + salary; 
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmployeeNum() {
		return employeeNum;
	}
	public void setEmployeeNum(int employeeNum) {
		this.employeeNum = employeeNum;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
