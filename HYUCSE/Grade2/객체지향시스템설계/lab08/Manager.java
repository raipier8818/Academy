package lab08;

public class Manager extends Employee{
	private double overtimeRate;
	private double rate;
	private int regularHrs;
	
	public Manager(String name, int employeeNum) {
		super(name, employeeNum);
		this.setDepartment("Management");
		this.overtimeRate = 8.0;
		this.rate = 4.0;
		this.regularHrs = 40;
	}
	
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		
		Manager other = (Manager) obj;
		return super.equals(obj) && this.getDepartment() == other.getDepartment();
	}
	
	public String toString() {
		return super.toString() + ", " + this.getDepartment();
	}
	
	public double getPaid() {
		int overtimeHrs = this.getWorkHrs() - regularHrs;
		if(this.getWorkHrs() < 40) return this.getWorkHrs() * rate;
		return (regularHrs * rate) + (overtimeHrs * overtimeRate);
	}
}
