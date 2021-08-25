package lab07;

public class Manager extends Employee{
	private int officeNum;
	private String team;
	
	public Manager(String name, int employeeNum, int officeNum, String team) {
		super(name,employeeNum,"Management");
		this.officeNum = officeNum;
		this.team = team;
	}
	
	public int getOfficeNum() {
		return this.officeNum;
	}

	public void setOfficeNum(int officeNum) {
		this.officeNum = officeNum;
	}

	public String getTeam() {
		return this.team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String toString() {
		String returnString = "";
		returnString += "Name : [" + this.getName() + "]\n";
		returnString += "Emp# : [" + this.getEmployeeNum() + "]\n";
		returnString += "Department : [" + this.getDepartment() + "]\n"; 
		returnString += "Office# : [" + this.getOfficeNum() + "]\n";
		returnString += "Team : [" + this.getTeam() + "]\n"; 
		
		return returnString;
	}
	
	public boolean equals(Object obj) {
		if(obj == null) return false;
		else if(getClass() != obj.getClass()) return false;

		Manager other = (Manager) obj;
		return super.equals(other) && this.officeNum == other.officeNum && this.team.equals(other.getTeam());
	}
	
	
}
