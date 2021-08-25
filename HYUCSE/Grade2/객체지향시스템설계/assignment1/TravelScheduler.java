package assignment1;

import java.util.*;

public class TravelScheduler {
	static Scanner keyboard = new Scanner(System.in);
	
	static boolean addActivity(Activity[] activityList, Schedule selectedSchedule) {
		for(int i = 0; i < 8; i++) {
			System.out.println((i+1) + ") " + activityList[i].toString());
		}
		
		System.out.print("Select activity to do : ");
		int activityNum;
		activityNum = keyboard.nextInt();
		if(activityNum > 8 || activityNum <= 0) return false;
		
		Activity selectedActivity = activityList[activityNum-1];
		
		int day, time;
		System.out.print("Enter the day to do activity : ");
		day = keyboard.nextInt();
		System.out.print("Enter the time to do activity(9~20) : ");
		time = keyboard.nextInt();
		
		return selectedSchedule.addActivity(day, time, selectedActivity);
	}
	
	static boolean removeActivity(Schedule selectedSchedule) {
		printSchedule(selectedSchedule);
		
		int day, time;
		System.out.print("Enter the day to remove activity : ");
		day = keyboard.nextInt();
		System.out.print("Enter the time to remove activity : ");
		time = keyboard.nextInt();
		
		return selectedSchedule.removeActivity(day, time);
	}

	static void printSchedule(Schedule selectedSchedule){
		if(selectedSchedule == null) return;
		selectedSchedule.printPlan();
	}
	
	
	static void selectSchedule(Schedule[] scheduleList, Activity[] activityList) {
		for(int i = 0; i < 5; i++) {
			if(scheduleList[i] == null) System.out.println((i+1) + ") EMPTY SCHEDULE");
			else System.out.println((i+1) + ") " + scheduleList[i].getName());
		}
		
		int scheduleNum;
		Schedule selectedSchedule = null;

		System.out.print("Select a schedule : ");
		
		scheduleNum = keyboard.nextInt();
		if(scheduleNum == 0) return;
		
		selectedSchedule = scheduleList[scheduleNum-1];
		if (selectedSchedule == null) return;

		
		int actNum;
		
		do {					

			System.out.println("1) Add activity");
			System.out.println("2) Remove activity");
			System.out.println("3) Print schedule");
			System.out.print("Select menu : ");
			
			
			actNum = keyboard.nextInt();
			
			if(actNum == 1) {
				if(!addActivity(activityList, selectedSchedule)) 
					System.out.println("Fail to add activity");
			}
	
			if(actNum == 2) {
				if(removeActivity(selectedSchedule))
					System.out.println("Removed successfully");
			}
			
			if(actNum == 3) {
				printSchedule(selectedSchedule);
			}	
		}while(actNum != 0);

	}
	
	static boolean makeNewSchedule(Schedule[] scheduleList) {		
		if(Schedule.scheduleNum >= scheduleList.length) return false;
		
		System.out.print("Enter a name for the schedule : ");
		String scheduleName = keyboard.nextLine();
		
		for(int i = 0; i < Schedule.scheduleNum; i++) {
			if(scheduleList[i].getName().equals(scheduleName)) return false;
		}
		
		
		System.out.print("Enter travel days : ");
		int days = keyboard.nextInt();
		scheduleList[Schedule.scheduleNum++] =  new Schedule(scheduleName, days);
		return true;
	}
	
	static boolean copyExistingSchedule(Schedule[] scheduleList) {
		for(int i = 0; i < 5; i++) {
			if(scheduleList[i] == null) System.out.println((i+1) + ") EMPTY SCHEDULE");
			else System.out.println((i+1) + ") " + scheduleList[i].getName());
		}
		
		System.out.print("Select the schedule to copy : ");
		int selectedNum = keyboard.nextInt();
		keyboard.nextLine();
		System.out.print("Enter a new schedule name : ");
		String scheduleName = keyboard.nextLine();
		
		if(scheduleList[selectedNum-1] == null) return false;
		for(int i = 0; i < Schedule.scheduleNum; i++) {
			if(scheduleList[i].getName().equals(scheduleName)) return false;
		}
		
		scheduleList[Schedule.scheduleNum++] = new Schedule(scheduleList[selectedNum-1], scheduleName);
		return true;
	}
	
	static void editSchedule(Schedule[] scheduleList, Activity[] activityList) {
		System.out.println("1) Make a new schedule");
		System.out.println("2) Copy an existing schedule");
		System.out.print("Select menu : ");
		
		
		int scheduleNum;
		scheduleNum = keyboard.nextInt();
		keyboard.nextLine();
		
		if(scheduleNum == 0) return;
		
		if(scheduleNum == 1) {
			makeNewSchedule(scheduleList);
		}
		
		if(scheduleNum == 2) {
			copyExistingSchedule(scheduleList);					
		}

	}
	
	
	public static void main(String[] args) {
		Schedule[] scheduleList = new Schedule[5];
		Activity[] activityList = new Activity[8];
		
		activityList[0] = new Activity("Hiking", "Mountain", 0);
		activityList[1] = new Activity("Horse Riding", "Hill", 3000);
		activityList[2] = new Activity("Visiting Museum", "Museum", 8000);
		activityList[3] = new Activity("Watching movie", "Theater", 11000);
		activityList[4] = new Activity("Fishing", "Sea", 15000);
		activityList[5] = new Activity("Surffing", "Beach", 20000);
		activityList[6] = new Activity("Camping", "Field", 30000);
		activityList[7] = new Activity("Paragliding", "Mountain", 50000);
		
		int menuNum;
		
		do {			
			System.out.println("1) Select schedule");
			System.out.println("2) Edit schedule");
			System.out.println("3) End program");
			System.out.print("Select menu : ");
			
			menuNum = keyboard.nextInt();
			
			if(menuNum == 1) {
				selectSchedule(scheduleList, activityList);								
			}else if (menuNum == 2) {
				editSchedule(scheduleList, activityList);
			}
		}while(menuNum != 3);
	}
}
