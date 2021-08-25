package lab08;

public class Engineer extends Employee {
	private double rate;
	
	public Engineer(String name, int employeeNum) {
		super(name, employeeNum);
		this.setDepartment("Engineering");
		this.rate = 4.0;
	}
	
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		
		Engineer other = (Engineer) obj;
		return super.equals(obj) && other.getDepartment() == this.getDepartment();
	}
	
	public String toString() {
		return super.toString() + ", " + this.getDepartment();
	}
	
	public double getPaid() {
		return this.getWorkHrs() * rate;
	}
}
