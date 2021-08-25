package lab07;

public class Employee {
	private String name;
	private int employeeNum;
	private String department;
	
	public Employee(String name, int employeeNum, String department) {
		this.name = name;
		this.employeeNum = employeeNum;
		this.department = department;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmployeeNum() {
		return this.employeeNum;
	}

	public void setEmployeeNum(int employeeNum) {
		this.employeeNum = employeeNum;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public boolean equals(Object obj) {
		if(obj == null) return false;
		else if(getClass() != obj.getClass()) return false;
		
		Employee other = (Employee) obj;
		
		return name.equals(other.getName()) && this.employeeNum == other.getEmployeeNum() && this.department.equals(other.getDepartment());
	}
	
	public String toString() {
		String returnString = "";
		returnString += "Name : [" + this.name + "]\n";
		returnString += "Emp# : [" + this.employeeNum + "]\n";
		returnString += "Department : [" + this.department + "]\n"; 
		return returnString;
	}
}
