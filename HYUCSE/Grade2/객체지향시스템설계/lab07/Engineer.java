package lab07;

public class Engineer extends Employee{
	private String workZone;
	private String project;
	
	public Engineer(String name, int employeeNum, String workZone, String project) {
		super(name, employeeNum, "Engineering");
		this.workZone = workZone;
		this.project = project;
	}
	
	
	public String getWorkZone() {
		return this.workZone;
	}



	public void setWorkZone(String workZone) {
		this.workZone = workZone;
	}



	public String getProject() {
		return this.project;
	}



	public void setProject(String project) {
		this.project = project;
	}



	public boolean equals(Object obj) {
		if(obj == null) return false;
		else if(getClass() != obj.getClass()) return false;
		
		Engineer other = (Engineer) obj;
		
		return super.equals(other) && this.workZone.equals(other.getWorkZone()) && this.project.equals(other.getProject());
	}
	
	public String toString() {
		String returnString = "";
		
		returnString += "Name : [" + this.getName() + "]\n";
		returnString += "Emp# : [" + this.getEmployeeNum() + "]\n";
		returnString += "Department : [" + this.getDepartment() + "]\n"; 
		returnString += "Zone : [" + this.getWorkZone() + "]\n";
		
		return returnString;
	}
}
