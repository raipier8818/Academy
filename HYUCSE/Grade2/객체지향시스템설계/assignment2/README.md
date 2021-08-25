# Assignment 2

## Development Environment   

 - OS : Window 10

 - Java : Java(TM) SE Runtime Environment (build 15.0.1+9-18)

## Configuration

- [Activity.java](#activity)

- [ExtremeActivity.java](#extremeactivity)

- [ShowActivity.java](#showactivity)

- [Schedule.java](#schedule)

- [TravelScheduler.java](#travelscheduler)

- [Person.java](#person)

- [ArrayFullException.java](#arrayfullexception)

- [InsufficientConditionException.java](#insufficientconditionexception)

- [InvalideAccessException.java](#invalidaccessexception)


##### [Run time](#runtime)

----

  

## *Activity*


<details>
<summary>Source Code</summary>
<div markdown='1'>

```java
package assignment2;

public class Activity {
	private String name;
	private String location;
	private int price;
	
	public Activity(String name, String location, int price) {
		this.name = name;
		this.location = location;
		this.price = price;
	}
	
	public Activity(Activity other) {
		this.name = other.name;
		this.location = other.location;
		this.price = other.price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString() {
		return this.name + "(" + this.location + ", " + this.price + " won)";
	}
	
	public boolean equals(Activity other) {
		return this.name.equals(other.getName()) && this.location.equals(other.getLocation()) && this.price == other.getPrice();
	}
	
	public int getActualPrice(Person person) {
		return this.price;
	}
}



```

</div>
</details>
  

  

### Variable

  

| Type | Variable Name | Description |
| :------------ | :----------- | :------------------- |
| private String | name | Activity name |
| private String | location | Activity location |
| private int | price | Activity price |

  

<br>

### Constructor

  

| parameter | Description |
| :------------ | :----------- |
| String name <br>String location <br>int price | set all private variable to parameter |
| Activity other | copy constructor |

  

<br>

  

### Method

| Return Type | Method Name | Parameter | Description |
| :------------ | :----------- | :------ |:------------------- |
| public String  | toString | Null | return Activity's **name**, **location** and **price** in String
| public boolean | equals | Activity other | return true if all variables in Other is equal to this
| public int | getActualPrice | Person person | return Activity's price
  
  


## *ExtremeActivity* 

 : class ExtremeActivity extends class Activity 

<details>
<summary>Source Code</summary>
<div markdown='1'>

```java
package assignment2;

public class ExtremeActivity extends Activity{
	private int minHeight;
	private int minWeight;
	
	public ExtremeActivity(String name, String location, int price, int minHeight, int minWeight) {
		super(name, location, price);
		this.minHeight = minHeight;
		this.minWeight = minWeight;
	}
	
	public ExtremeActivity(ExtremeActivity other) {
		super(other);
		this.minHeight = other.minHeight;
		this.minWeight = other.minWeight;
	}
	
	public int getMinHeight() {
		return minHeight;
	}



	public void setMinHeight(int minHeight) {
		this.minHeight = minHeight;
	}



	public int getMinWeight() {
		return minWeight;
	}



	public void setMinWeight(int minWeight) {
		this.minWeight = minWeight;
	}



	public int getActualPrice(Person person) {
		if(person.getAge() >= 60) return (int)(this.getPrice()*1.3);
		return this.getPrice();
	}
}


```

</div>
</details>
  
### Variable

  

| Type | Variable Name | Description |
| :------------ | :----------- | :------------------- |
| private String | name | Activity name |
| private String | location | Activity location |
| private int | price | Activity price |
| private int | minHeight | Activity's minimum height |
| private int | minWeight | Activity's minimum weight |

  

<br>

### Constructor

  

| parameter | Description |
| :------------ | :----------- |
| String name <br>String location <br>int price <br>int minHeight <br>int minWeight| set all private variable to parameter |
| ExtremeActivity other | copy constructor |

  

<br>

  

### Method

| Return Type | Method Name | Parameter | Description |
| :------------ | :----------- | :------ |:------------------- |
| public String  | toString | Null | return Activity's **name**, **location** and **price** in String
| public boolean | equals | Activity other | return true if all variables in Other is equal to this
| public int | getActualPrice | Person person | return price as a parameter (person's age)
  
  
## *ShowActivity* 

 : class ShowActivity extends class Activity 

<details>
<summary>Source Code</summary>
<div markdown='1'>

```java
package assignment2;

public class ShowActivity extends Activity{
	private int minAge;
	
	public ShowActivity(String name, String location, int price, int minAge) {
		super(name, location, price);
		this.minAge = minAge;
	}
	
	public ShowActivity(ShowActivity other) {
		super(other);
		this.minAge = other.getMinAge();
	}

	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}
	
	public int getActualPrice(Person person) {
		if(person.getAge() <= 19) return (int)(this.getPrice()*0.8);
		return this.getPrice();
	}
}


```

</div>
</details>
  
### Variable

  

| Type | Variable Name | Description |
| :------------ | :----------- | :------------------- |
| private String | name | Activity name |
| private String | location | Activity location |
| private int | price | Activity price |
| private int | minAge | Activity's minimum age |

  

<br>

### Constructor

  

| parameter | Description |
| :------------ | :----------- |
| String name <br>String location <br>int price <br>int minAge | set all private variable to parameter |
| ShowActivity other | copy constructor |

  

<br>

  

### Method

| Return Type | Method Name | Parameter | Description |
| :------------ | :----------- | :------ |:------------------- |
| public String  | toString | Null | return Activity's **name**, **location** and **price** in String
| public boolean | equals | Activity other | return true if all variables in Other is equal to this
| public int | getActualPrice | Person person | return price as a parameter (person's age)
  

## *Schedule*
   

<details>
<summary>Source Code</summary>
<div markdown='1'>

```java
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


```

</div>
</details>
  

  

### Variable

  

| Type | Variable Name | Description |
| :------------ | :----------- | :------------------- |
| private String | name | Activity name  	 |
| private int 	 | days | Schedule total day |
| private Activity | plan | Activities array |
| private int | expense | total price in plan |
| private Person[] | member | array of member in schedule  |
| private int | memberNum | num of members in member  |
| public static int | scheduleNum | the number of Schedule  |

  

<br>

### Constructor

  

| parameter | Description |
| :------------ | :----------- |
| String name <br>int days | set **name** and **days** to parameter, set expense to 0 and set all **plan**'s element to null |
| Schedule other | copy constructor |
| Schedule other <br>String newName | copy other's **plan** and set **name** to newName |

  

<br>

  

### Method

| Return Type | Method Name | Parameter | Description |
| :------------ | :----------- | :------ |:------------------- |
| public Activity[][] | getPlan | Null | return **plan** (shallow copy)
| public boolean | checkActivity | Activity newActivity <br>int day <br>int time | 
| public void | addMember | Person p | add a Person(p) in member
| public void | setMember | int size | allocate member (size of person)
| public Person[] | getMember | Null | return member (deep copy)return true if newActivity can be added in **plan[day][time]**
| public void | printPlan | Null | print plan
| public boolean | removeActivity | int day <br>int time | return true if it can remove Activity in **plan[day][time]** and update expense
| public boolean | addActivity | int day <br>int time <br>Activity selectedActivity | return true if it can add selectedActivity to **plan[day][time]** and update **expense**
| public void | checkException | Activity newActivity | if activity is insufficient, *throws* InsufficientConditionException |  

  
  
  

## *TravelScheduler*

  
<details>
<summary>Source Code</summary>
<div markdown='1'>

```java
package assignment2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.*;

public class TravelScheduler {
	static Scanner keyboard = new Scanner(System.in);
	static Person[] memberList;
	static int activityListNum;
	static int memberListNum;
	
	static boolean addActivity(Activity[] activityList, Schedule selectedSchedule) {
		for(int i = 0; i < activityListNum; i++) {
			System.out.println((i+1) + ") " + activityList[i].toString());
		}
		int activityNum;
		int day, time;	
		
		try {
			System.out.print("Select activity to do : ");
			activityNum = keyboard.nextInt();
			if(activityNum > activityListNum || activityNum <= 0) throw new InvalidAccessException(activityNum);
			
			Activity selectedActivity = activityList[activityNum-1];
			
			System.out.print("Enter the day to do activity : ");
			day = keyboard.nextInt();
			System.out.print("Enter the time to do activity(9~20) : ");
			time = keyboard.nextInt();
			
			
			selectedSchedule.checkException(selectedActivity);

			if(!selectedSchedule.addActivity(day, time, selectedActivity)) throw new InvalidAccessException(0);
			else return true;
		}catch(InsufficientConditionException e) {
			System.out.println(e.getMessage());
			return false;
		}catch(InvalidAccessException e) {
			System.out.println(e.getMessage());
			return false;
		}catch(InputMismatchException e) {
			System.out.println("Input Mismatch Exception");
			return false;
		}
		
	}
	
	static boolean removeActivity(Schedule selectedSchedule) {
		selectedSchedule.printPlan();
		
		
		try {
			int day, time;
			System.out.print("Enter the day to remove activity : ");
			day = keyboard.nextInt();
			System.out.print("Enter the time to remove activity : ");
			time = keyboard.nextInt();
			
			if(!selectedSchedule.removeActivity(day, time)) throw new InvalidAccessException(0);	
		} catch (InvalidAccessException e) {
			System.out.println(e.getMessage());
			return false;
		}catch(InputMismatchException e) {
			System.out.println("Input Mismatch Exception");
			return false;
		}
		
		return true;
		
	}
	
	
	static void selectSchedule(Schedule[] scheduleList, Activity[] activityList) {
		for(int i = 0; i < 5; i++) {
			if(scheduleList[i] == null) System.out.println((i+1) + ") EMPTY SCHEDULE");
			else System.out.println((i+1) + ") " + scheduleList[i].getName());
		}
		
		int scheduleNum;
		Schedule selectedSchedule = null;

		System.out.print("Select a schedule : ");
		
		try {
			scheduleNum = keyboard.nextInt();
			if(scheduleNum == 0) return;
			else if(scheduleNum > 5) throw new InvalidAccessException(scheduleNum);
			
			selectedSchedule = scheduleList[scheduleNum-1];
			if (selectedSchedule == null) throw new InvalidAccessException(scheduleNum);
		} catch (InvalidAccessException e) {
			System.out.println(e.getMessage());
			return;
		} catch (InputMismatchException e) {
			System.out.println("Input Mismatch Exception");
			return;
		}
		

		
		int actNum = 0;
		
		do {		
			try {
				System.out.println("1) Add activity");
				System.out.println("2) Remove activity");
				System.out.println("3) Print schedule");
				System.out.print("Select menu : ");
				
				
				actNum = keyboard.nextInt();
				
				if(actNum == 1) {
					if(!addActivity(activityList, selectedSchedule)) System.out.println("Fail to add activity");			
				}
				else if(actNum == 2) {
					if(removeActivity(selectedSchedule))
						System.out.println("Removed successfully");
				}
				else if(actNum == 3) {
					if(selectedSchedule == null) continue;
					selectedSchedule.printPlan();
				}
				else if(actNum != 0) throw new InvalidAccessException(actNum);
			} catch (InvalidAccessException e) {
				System.out.println(e.getMessage());
				continue;
			} catch(InputMismatchException e) {
				System.out.println("Input Mismatch Exception");
				continue;
			}

		}while(actNum != 0);

	}
	
	static boolean makeNewSchedule(Schedule[] scheduleList) {
		try {
			if(Schedule.scheduleNum >= scheduleList.length) throw new ArrayFullException(Schedule.scheduleNum);	
			

			System.out.print("Enter a name for the schedule : ");
			String scheduleName = keyboard.nextLine();
			
			for(int i = 0; i < Schedule.scheduleNum; i++) {
				if(scheduleList[i].getName().equals(scheduleName)) return false;
			}
			
			
			System.out.print("Enter travel days : ");
			int days = keyboard.nextInt();
			scheduleList[Schedule.scheduleNum] =  new Schedule(scheduleName, days);
			scheduleList[Schedule.scheduleNum].setMember(memberListNum);
			
			for(int i = 0; i < memberListNum; i++) {
				System.out.println((i + 1) + ". " + memberList[i].toString());
			}
			
			keyboard.nextLine();

			System.out.print("Choose members you want to Add (Enter the numbers in line) : ");
			String line = keyboard.nextLine();
			String[] members = line.split(" ");
			
			for(int i = 0; i < members.length; i++) {
				if(Integer.parseInt(members[i]) - 1 >= memberList.length) throw new InvalidAccessException(Integer.parseInt(members[i]) - 1);
				scheduleList[Schedule.scheduleNum].addMember(memberList[Integer.parseInt(members[i]) - 1]);
			}
			
			Schedule.scheduleNum += 1;
			
			
			
		}catch(ArrayFullException e){
			System.out.println(e.getMessage());
			return false;
		}catch(InvalidAccessException e) {
			System.out.println(e.getMessage());
			return false;
		}catch(InputMismatchException e) {
			System.out.println("Input Mismatch Exception");
			return false;
		}catch(NumberFormatException e) {
			System.out.println("Input Mismatch Exception");
			return false;
		}
		
		
		return true;
	}
	
	static boolean copyExistingSchedule(Schedule[] scheduleList) {
		try {
			if(Schedule.scheduleNum >= scheduleList.length) throw new ArrayFullException(Schedule.scheduleNum);
			
			for(int i = 0; i < 5; i++) {
				if(scheduleList[i] == null) System.out.println((i+1) + ") EMPTY SCHEDULE");
				else System.out.println((i+1) + ") " + scheduleList[i].getName());
			}
			
			System.out.print("Select the schedule to copy : ");
			int selectedNum = keyboard.nextInt();
			keyboard.nextLine();
			System.out.print("Enter a new schedule name : ");
			String scheduleName = keyboard.nextLine();
			
			if(scheduleList[selectedNum-1] == null) throw new InvalidAccessException(0);
			for(int i = 0; i < Schedule.scheduleNum; i++) {
				if(scheduleList[i].getName().equals(scheduleName)) return false;
			}
			
			scheduleList[Schedule.scheduleNum++] = new Schedule(scheduleList[selectedNum-1], scheduleName);
				
		} catch (InvalidAccessException e) {
			System.out.println(e.getMessage());
			return false;
		} catch(InputMismatchException e) {
			System.out.println("Input Mismatch Exception");
			return false;
		} catch(ArrayFullException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	static void editSchedule(Schedule[] scheduleList, Activity[] activityList) {
		System.out.println("1) Make a new schedule");
		System.out.println("2) Copy an existing schedule");
		System.out.print("Select menu : ");
		
		try {

			int scheduleNum;
			scheduleNum = keyboard.nextInt();
			keyboard.nextLine();
			
			if(scheduleNum == 0) return;
			
			else if(scheduleNum == 1) {
				makeNewSchedule(scheduleList);
			}
			
			else if(scheduleNum == 2) {
				copyExistingSchedule(scheduleList);					
			}
			else throw new InvalidAccessException(scheduleNum);
	
		} catch (InvalidAccessException e) {
			System.out.println(e.getMessage());
			return;
		} catch (InputMismatchException e) {
			System.out.println("Input Mismatch Exception");
			return;
		}
		
	}
	
	
	public static void main(String[] args) {
		Schedule[] scheduleList = new Schedule[5];
		Activity[] activityList;
		
		
		try {
			Scanner ActivityListFile = new Scanner(new FileInputStream("ActivityList.txt"));
			Scanner MemberListFile = new Scanner(new FileInputStream("MemberList.txt"));
			
			activityListNum = ActivityListFile.nextInt();
			ActivityListFile.nextLine();
			
			memberListNum = MemberListFile.nextInt();
			MemberListFile.nextLine();
			
			activityList = new Activity[activityListNum];
			memberList = new Person[memberListNum];
			
			
			for(int i = 0; i < activityListNum; i++) {
				String input = ActivityListFile.nextLine();
				String[] line = input.split(", ");
				Activity newActivity;
				
				
				if(line[0].equals("Activity")){
					if(line.length == 4) newActivity = new Activity(line[1],line[2],Integer.parseInt(line[3]));
					else newActivity = new Activity(line[1], null, Integer.parseInt(line[2]));
				}else if(line[0].equals("Show")) {
					if(line.length == 5) newActivity = new ShowActivity(line[1], line[2], Integer.parseInt(line[3]), Integer.parseInt(line[4]));
					else newActivity = new ShowActivity(line[1], null,  Integer.parseInt(line[2]), Integer.parseInt(line[3]));
				}else if(line[0].equals("Extreme")) {
					if(line.length == 5) {
						newActivity = new ExtremeActivity(line[1], "null", Integer.parseInt(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4]));
					}else newActivity = new ExtremeActivity(line[1], line[2], Integer.parseInt(line[3]), Integer.parseInt(line[4]), Integer.parseInt(line[5]));
				}else {
					newActivity = null;
				}
				
				activityList[i] = newActivity;
				
				
			}
			
			for(int i = 0; i < memberListNum; i++) {
				String input = MemberListFile.nextLine();
				String[] line = input.split(", ");
				
				Person newMember;
				newMember = new Person(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]));
				memberList[i] = newMember;
				
			}
			
			int menuNum = 3;
			
			do {
				System.out.println("1) Select schedule");
				System.out.println("2) Edit schedule");
				System.out.println("3) End program");
				System.out.print("Select menu : ");
				
				try {
					menuNum = keyboard.nextInt();
					
					if(menuNum == 1) {
						selectSchedule(scheduleList, activityList);								
					}else if (menuNum == 2) {
						editSchedule(scheduleList, activityList);
					}else if(menuNum != 3) throw new InvalidAccessException(menuNum);
						
				} catch (InvalidAccessException e) {
					System.out.println(e.getMessage());
				} catch (InputMismatchException e) {
					System.out.println("Input Mismatch Exception");
				}
				
			}while(menuNum != 3);
			
			
			ActivityListFile.close();
			MemberListFile.close();
			
		}catch(Exception e) {
			System.exit(0);
		}
		
	}
}

```

</div>
</details>
  

### Method

   

| Return Type | Method Name | Parameter |
| :------------ | :----------- | :------ | 
| public static void | main | String[] args 
| static void | selectSchedule | Schedule[] scheduleList <br>Activity[] activityList | 
| static void | editSchedule   | Schedule[] scheduleList <br>Activity[] activityList | 
| static boolean | addActivity | Activity[] activityList <br> Schedule selectedSchedule| 
| public boolean | removeActivity | Schedule selectedSchedule |
| public void	 | printSchedule | Schedule selectedSchedule| 
| public boolean | makeNewSchedule | Schedule[] scheduleList |
| public boolean | copyExistingSchedule | Schedule[] scheduleList |  


### Method Description

| Method Name | Description |
| :-----------------:| :------------|
| main | Declare and Allocate scheduleList[], activityList[]. <br>And initialize activityList from text file. <br>Enter an integer to select menu using Scanner while num is not 3. <br>1. Do **selectSchedule** <br>2. Do **editSchedule** <br>3. Exit program 
| selectSchedule | Print scheduleList. <br> Enter an Integer to select Schedule using Scanner. <br> Enter an Integer to select menu using Scanner while num is not 0.<br> 1. If **addActivity** is false, print "Fail to add activity"<br>2. If **removeActivity** is true, print "Removed successfully"<br> 3. Do **printSchedule**.
| editSchedule | Enter an integer to select menu using Scanner.<br>0. Return<br>1. Do **makeNewSchedule**.<br>2. Do **copyExistingSchedule**.
| addActivity  | Print activityList.<br>Enter an integer to select Activity<br>Enter two integers. (day, time)<br> return true if selected Activity can be added in selected Schedule.<br> (using selectedSchedule.addActivity(day, time, selectedActivity))
| removeActivity  | Print selected Schedule's plan.<br>Enter two integers. (day, time)<br>return true if it can remove Activity in selected Schedule's plan. <br>(using selectedSchedule.removeActivity(day,time))
| printSchedule  | Print selected Schedule's plan<br>(using selectedSchedule.printPlan())
| makeNewSchedule  | If the number of Schedule is not less than 5, return false.<br>Enter the new Schedule name.<br>If there is a Schedule has same name, return false.<br>Enter travel days, make new Schedule and return true.
| copyExistingSchedule  | Enter an integer to select Schedule to copy plan.<br>Enter the new Schedule name.<br>If selected Schedule is null or there is a Schedule already has same name, return false.<br>Make new Schedule and return true.


## *Person*

<details>
<summary>Source Code</summary>
<div markdown='1'>

```java
package assignment2;

public class Person {
	private String name;
	private int age;
	private int height;
	private int weight;
	
	public Person(String name, int age, int height, int weight){
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	public Person(Person other) {
		this.name = other.name;
		this.age = other.age;
		this.height = other.height;
		this.weight = other.weight;
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
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public String toString() {
		return "Name : " + name + ", Age : " + age + ", Height : " + height + ", Weight : " + weight;
	}
	
}

```
</div>
</details>
  
### Variable

  

| Type | Variable Name | Description |
| :------------ | :----------- | :------------------- |
| private String | name | Person name |
| private int | age | Person age |
| private int | height | Person height |
| private int | weight | Person weight |

  

<br>

### Constructor

  

| parameter | Description |
| :------------ | :----------- |
| String name <br>int age<br>int height<br>int weight | set all private variable to parameter |
| Person other | copy constructor |

  

<br>

  

### Method

| Return Type | Method Name | Parameter | Description |
| :------------ | :----------- | :------ |:------------------- |
| String | toString | Null | return Person's information |
  

## *InsufficientConditionException*

 : class InsufficientConditionException extends Exception

<details>
<summary>Source Code</summary>
<div markdown='1'>

```java
package assignment2;

public class InsufficientConditionException extends Exception{
	 public InsufficientConditionException() {
		 super("Insufficient Condition Exception");
	 }
}

```
</div>
</details>
  
 - getMessage() : return "Insufficient Condition Exception"

## *InvalidAccessException*

 : class InvalidAccessException extends Exception

<details>
<summary>Source Code</summary>
<div markdown='1'>

```java
package assignment2;

public class InvalidAccessException extends Exception{
	private int number;
	
	public InvalidAccessException(int number) {
		super("Invalid Access Exception");
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}
}

```
</div>
</details>
  
 - getMessage() : return "Invalid Access Exception"






<br>

# Runtime

![1](/uploads/8fd5a80dafbd380d2de89305104a3b4b/1.PNG)

<br>

![2](/uploads/215028c0967fbf41a96eb6c36fe35d76/2.PNG)