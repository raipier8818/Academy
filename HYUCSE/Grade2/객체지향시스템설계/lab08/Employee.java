package lab08;

public abstract class Employee {
	private String name;
	private int employeeNum;
	private String department;
	private int workHrs;
	private double salary;
	
	public Employee(String name, int employeeNum) {
		this.name = name;
		this.employeeNum = employeeNum;
		this.workHrs = 0;
		this.salary = 0;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getWorkHrs() {
		return workHrs;
	}

	public double getSalary() {
		return salary;
	}
	
	public String getName() {
		return name;
	}
	
	public int getEmployeeNum() {
		return employeeNum;
	}
	
	public boolean equals(Object obj) {
		if(obj == null) return false;
		else if(getClass() != obj.getClass()) return false;
		
		Employee other = (Employee) obj;
		return this.name.equals(other.getName()) && this.employeeNum == other.getEmployeeNum();	
	}
	
	public String toString() {
		return name + ", " + employeeNum;
	}
	
	public void doWork(int hrs) {
		this.workHrs += hrs;
		this.salary = getPaid();
	}
	
	public abstract double getPaid();
}
