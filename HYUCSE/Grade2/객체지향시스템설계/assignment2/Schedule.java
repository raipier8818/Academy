package assignment2;

public class Schedule {
	private String name;
	private int days;
	private Activity[][] plan;
	private int expense;
	private Person[] member;
	private int memberNum;
	
	public static int scheduleNum = 0;
	
	
	public Schedule(String name, int days) {
		this.name = name;
		this.days = days;
		this.expense = 0;
		
		this.plan = new Activity[days][];
		for(int i = 0; i < days; i++) {
			this.plan[i] = new Activity[12];
		}
	}
	
	public Schedule(Schedule other) {
		this.name = other.getName();
		this.days = other.getDays();
		this.expense = other.getExpense();
		
		this.plan = new Activity[days][];
		for(int i = 0; i < days; i++) {
			this.plan[i] = new Activity[12];
		}
		
		for(int i = 0; i < days; i++) {
			for(int j = 0; j < 12; j++) {
				if(other.getPlan()[i][j] == null) continue;
				
				Activity copyActivity = new Activity(other.getPlan()[i][j]);
				plan[i][j] = copyActivity;
			}
		}
		
		this.member = other.getMember();
	}
	
	public Schedule(Schedule other, String newName) {
		this(other);
		this.name = newName;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public Activity[][] getPlan() {
		return plan;
	}

	public void setPlan(Activity[][] plan) {
		this.plan = plan;
	}

	public int getExpense() {
		return expense;
	}

	public void setExpense(int expense) {
		this.expense = expense;
	}
	
	public void addMember(Person p) {
		Person newPerson = new Person(p);
		member[memberNum++] = newPerson;
	}
	
	public void setMember(int size) {
		this.member = new Person[size];
		this.memberNum = 0;
	}
	
	public Person[] getMember() {
		Person[] returnMember = new Person[member.length];
		int idx = 0;
		for(Person target : member) {
			if(target == null) continue;
			Person copy = new Person(target);
			returnMember[idx++] = copy;
		}
		
		return returnMember;
	}
	
	public boolean checkActivity(Activity newActivity, int day, int time){
		day -= 1;
		time -= 9;
		if(plan[day][time] != null) return false;
		for(int i = 0; i < days; i++) {
			for(int j = 0; j < 12; j++) {
				if(plan[i][j] != null && plan[i][j].getName() == newActivity.getName()) return false;
			}
		}		
		
		return true;
	}
	
	public void printPlan() {
		System.out.println("-".repeat((days + 1)*16));
		System.out.print(" ".repeat(16));
		for(int i = 0; i < days; i++) {
			System.out.printf("%-16s", "Day " + (i+1));
		}
		
		System.out.println();
		
		for(int i = 0; i < 12; i++) {
			System.out.printf("%-16s", (i+9) + ":00");
			
			for(int j = 0; j < days; j++) {
				if(plan[j][i] == null) System.out.printf("%-16s", "----");
				else System.out.printf("%-16s", plan[j][i].getName());
			}
			
			System.out.println();
		}
		System.out.println("-".repeat((days + 1)*16));
		System.out.println("Members of Schedule");
		
		for(int i = 0; i < memberNum; i++) {
			System.out.println((i+1) + ". " + member[i].toString());
		}
		
		System.out.println("-".repeat((days + 1)*16));
		System.out.println("Total expenses : " + expense);
		System.out.println("-".repeat((days + 1)*16));
		
	}
	
	public boolean removeActivity(int day, int time) {
		if(day > this.getDays() || day <= 0 || time > 20 || time < 9) return false;
		if(this.getPlan()[day-1][time-9] == null) return false;
		
		for(Person person : member) {
			if(person == null) continue;
			this.expense -= this.getPlan()[day-1][time-9].getActualPrice(person);
		}
		
		this.getPlan()[day-1][time-9] = null;
		
		return true;
	}
	
	public boolean addActivity(int day, int time, Activity selectedActivity)
	{
		if(day > this.getDays() || day <= 0 || time > 20 || time < 9) return false;
		
		if(this.checkActivity(selectedActivity, day, time) == true) {
			this.getPlan()[day-1][time-9] = selectedActivity;
			for(Person person : member) {
				if(person == null) continue;
				this.expense += selectedActivity.getActualPrice(person);
			}
			
			return true;
		}
		return false;
	}
	
	
	public void checkException(Activity newActivity) throws InsufficientConditionException{
		
		if(newActivity instanceof ExtremeActivity) {
			ExtremeActivity check = (ExtremeActivity)newActivity;
			for(int i = 0; i < memberNum; i++) {
				if(member[i].getHeight() < check.getMinHeight() || member[i].getWeight() < check.getMinWeight()) throw new InsufficientConditionException();
			}
		}
		else if(newActivity instanceof ShowActivity) {
			ShowActivity check = (ShowActivity)newActivity;
			for(int i = 0; i < memberNum; i++) {
				if(member[i].getAge() < check.getMinAge()) throw new InsufficientConditionException();
			}
		}
	}
}
